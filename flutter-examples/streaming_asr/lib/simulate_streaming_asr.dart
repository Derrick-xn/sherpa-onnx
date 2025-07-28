// Copyright (c)  2024  Xiaomi Corporation
import 'dart:async';
import 'dart:typed_data';

import 'package:flutter/foundation.dart';
import 'package:flutter/material.dart';
import 'package:path/path.dart' as p;
import 'package:path_provider/path_provider.dart';
import 'package:record/record.dart';

import 'package:sherpa_onnx/sherpa_onnx.dart' as sherpa_onnx;
import './utils.dart';

// 创建SenseVoice离线识别器
Future<sherpa_onnx.OfflineRecognizer> createSenseVoiceRecognizer() async {
  final modelDir =
      'assets/models/sherpa-onnx-sense-voice-zh-en-ja-ko-yue-2024-07-17';

  final senseVoiceConfig = sherpa_onnx.OfflineSenseVoiceModelConfig(
    model: await copyAssetFile('$modelDir/model.int8.onnx'),
    language: '', // 空字符串表示自动检测语言
    useInverseTextNormalization: false,
  );

  final modelConfig = sherpa_onnx.OfflineModelConfig(
    senseVoice: senseVoiceConfig,
    tokens: await copyAssetFile('$modelDir/tokens.txt'),
    modelType: 'sense_voice',
    numThreads: 2,
  );

  final config = sherpa_onnx.OfflineRecognizerConfig(
    model: modelConfig,
  );

  return sherpa_onnx.OfflineRecognizer(config);
}

// 创建VAD
Future<sherpa_onnx.VoiceActivityDetector> createVAD() async {
  final sileroVadConfig = sherpa_onnx.SileroVadModelConfig(
    model: await copyAssetFile('assets/silero_vad.onnx'),
    minSilenceDuration: 0.25,
    minSpeechDuration: 0.25,
    maxSpeechDuration: 5.0,
  );

  final vadConfig = sherpa_onnx.VadModelConfig(
    sileroVad: sileroVadConfig,
    sampleRate: 16000,
    numThreads: 1,
  );

  return sherpa_onnx.VoiceActivityDetector(
      config: vadConfig, bufferSizeInSeconds: 10);
}

class SimulateStreamingAsrScreen extends StatefulWidget {
  const SimulateStreamingAsrScreen({super.key});

  @override
  State<SimulateStreamingAsrScreen> createState() =>
      _SimulateStreamingAsrScreenState();
}

class _SimulateStreamingAsrScreenState
    extends State<SimulateStreamingAsrScreen> {
  late final TextEditingController _controller;
  late final AudioRecorder _audioRecorder;

  String _title = 'SenseVoice多语言实时识别 (模拟流式)';
  String _last = '';
  int _index = 0;
  bool _isInitialized = false;

  sherpa_onnx.OfflineRecognizer? _recognizer;
  sherpa_onnx.VoiceActivityDetector? _vad;
  int _sampleRate = 16000;

  StreamSubscription<RecordState>? _recordSub;
  RecordState _recordState = RecordState.stop;

  // 音频缓存
  final List<double> _audioBuffer = [];
  Timer? _processingTimer;

  @override
  void initState() {
    _audioRecorder = AudioRecorder();
    _controller = TextEditingController();

    _recordSub = _audioRecorder.onStateChanged().listen((recordState) {
      _updateRecordState(recordState);
    });

    super.initState();
  }

  Future<void> _start() async {
    if (!_isInitialized) {
      sherpa_onnx.initBindings();

      try {
        _recognizer = await createSenseVoiceRecognizer();
        _vad = await createVAD();
        _isInitialized = true;

        print('SenseVoice识别器和VAD初始化成功');
      } catch (e) {
        print('初始化失败: $e');
        return;
      }
    }

    try {
      if (await _audioRecorder.hasPermission()) {
        const encoder = AudioEncoder.pcm16bits;

        if (!await _isEncoderSupported(encoder)) {
          return;
        }

        const config = RecordConfig(
          encoder: encoder,
          sampleRate: 16000,
          numChannels: 1,
        );

        final stream = await _audioRecorder.startStream(config);

        // 启动定时处理
        _processingTimer = Timer.periodic(
          const Duration(milliseconds: 100),
          (_) => _processAudioBuffer(),
        );

        stream.listen(
          (data) {
            final samplesFloat32 =
                convertBytesToFloat32(Uint8List.fromList(data));

            // 添加到缓存
            _audioBuffer.addAll(samplesFloat32);

            // 如果缓存过大，移除旧数据 (保持最近10秒)
            if (_audioBuffer.length > _sampleRate * 10) {
              _audioBuffer.removeRange(
                  0, _audioBuffer.length - _sampleRate * 10);
            }
          },
          onDone: () {
            print('音频流停止');
            _processingTimer?.cancel();
          },
        );
      }
    } catch (e) {
      print('启动录音失败: $e');
    }
  }

  void _processAudioBuffer() {
    if (_audioBuffer.isEmpty || _vad == null || _recognizer == null) return;

    try {
      // 处理音频缓存
      final Float32List samples = Float32List.fromList(_audioBuffer);
      _vad!.acceptWaveform(samples);

      // 检查是否有语音段
      while (!_vad!.isEmpty()) {
        final speechSegment = _vad!.front();
        _vad!.pop();

        // 对语音段进行识别
        final stream = _recognizer!.createStream();
        stream.acceptWaveform(
            samples: speechSegment.samples, sampleRate: _sampleRate);

        _recognizer!.decode(stream); // decode返回void
        final result = _recognizer!.getResult(stream);
        final text = result.text.trim();

        if (text.isNotEmpty) {
          _updateDisplayText(text);
        }

        stream.free();
      }

      // 清空已处理的缓存
      _audioBuffer.clear();
    } catch (e) {
      print('处理音频失败: $e');
    }
  }

  void _updateDisplayText(String text) {
    setState(() {
      String textToDisplay;
      if (_last.isEmpty) {
        textToDisplay = '$_index: $text';
      } else {
        textToDisplay = '$_index: $text\n$_last';
      }

      _last = textToDisplay;
      _index += 1;

      _controller.value = TextEditingValue(
        text: textToDisplay,
        selection: TextSelection.collapsed(offset: textToDisplay.length),
      );
    });
  }

  Future<void> _stop() async {
    _processingTimer?.cancel();
    _audioBuffer.clear();
    await _audioRecorder.stop();
  }

  Future<void> _pause() => _audioRecorder.pause();
  Future<void> _resume() => _audioRecorder.resume();

  void _updateRecordState(RecordState recordState) {
    setState(() => _recordState = recordState);
  }

  Future<bool> _isEncoderSupported(AudioEncoder encoder) async {
    final isSupported = await _audioRecorder.isEncoderSupported(encoder);

    if (!isSupported) {
      debugPrint('${encoder.name} is not supported on this platform.');
      debugPrint('Supported encoders are:');

      for (final e in AudioEncoder.values) {
        if (await _audioRecorder.isEncoderSupported(e)) {
          debugPrint('- ${e.name}');
        }
      }
    }

    return isSupported;
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: Text(_title),
          backgroundColor: Colors.blue[700],
          foregroundColor: Colors.white,
        ),
        body: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Container(
              padding: const EdgeInsets.all(16),
              margin: const EdgeInsets.all(16),
              decoration: BoxDecoration(
                color: Colors.blue[50],
                borderRadius: BorderRadius.circular(8),
                border: Border.all(color: Colors.blue[200]!),
              ),
              child: Column(
                children: [
                  const Icon(Icons.info_outline, color: Colors.blue),
                  const SizedBox(height: 8),
                  const Text(
                    'SenseVoice多语言模型',
                    style: TextStyle(fontWeight: FontWeight.bold),
                  ),
                  const SizedBox(height: 4),
                  const Text(
                    '支持中文、英文、日文、韩文、粤语混合识别',
                    style: TextStyle(fontSize: 12, color: Colors.grey),
                  ),
                  const SizedBox(height: 4),
                  Text(
                    _isInitialized ? '✅ 已初始化' : '⏳ 初始化中...',
                    style: TextStyle(
                      fontSize: 12,
                      color: _isInitialized ? Colors.green : Colors.orange,
                    ),
                  ),
                ],
              ),
            ),
            Expanded(
              child: Container(
                margin: const EdgeInsets.all(16),
                padding: const EdgeInsets.all(16),
                decoration: BoxDecoration(
                  border: Border.all(color: Colors.grey[300]!),
                  borderRadius: BorderRadius.circular(8),
                ),
                child: TextField(
                  maxLines: null,
                  expands: true,
                  controller: _controller,
                  readOnly: true,
                  style: const TextStyle(fontSize: 16),
                  decoration: const InputDecoration(
                    border: InputBorder.none,
                    hintText: '识别结果将显示在这里...',
                  ),
                ),
              ),
            ),
            const SizedBox(height: 20),
            Row(
              mainAxisAlignment: MainAxisAlignment.center,
              children: <Widget>[
                _buildRecordStopControl(),
                const SizedBox(width: 20),
                _buildText(),
              ],
            ),
            const SizedBox(height: 50),
          ],
        ),
      ),
    );
  }

  @override
  void dispose() {
    _processingTimer?.cancel();
    _recordSub?.cancel();
    _audioRecorder.dispose();
    _recognizer?.free();
    _vad?.free();
    super.dispose();
  }

  Widget _buildRecordStopControl() {
    late Icon icon;
    late Color color;

    if (_recordState != RecordState.stop) {
      icon = const Icon(Icons.stop, color: Colors.red, size: 30);
      color = Colors.red.withOpacity(0.1);
    } else {
      final theme = Theme.of(context);
      icon = Icon(Icons.mic, color: theme.primaryColor, size: 30);
      color = theme.primaryColor.withOpacity(0.1);
    }

    return ClipOval(
      child: Material(
        color: color,
        child: InkWell(
          child: SizedBox(width: 56, height: 56, child: icon),
          onTap: () {
            (_recordState != RecordState.stop) ? _stop() : _start();
          },
        ),
      ),
    );
  }

  Widget _buildText() {
    if (_recordState == RecordState.stop) {
      return const Text("开始录音");
    } else {
      return const Text("停止录音");
    }
  }
}
