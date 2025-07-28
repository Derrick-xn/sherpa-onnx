// Copyright (c)  2024  Xiaomi Corporation
import 'dart:async';
import 'dart:typed_data';
import 'dart:collection';

import 'package:flutter/foundation.dart';
import 'package:flutter/material.dart';
import 'package:path/path.dart' as p;
import 'package:path_provider/path_provider.dart';
import 'package:record/record.dart';

import 'package:sherpa_onnx/sherpa_onnx.dart' as sherpa_onnx;
import './utils.dart';

// 🔧 优化后的SenseVoice配置 - 基于反编译APK分析
Future<sherpa_onnx.OfflineRecognizer> createSenseVoiceRecognizer() async {
  final modelDir =
      'assets/models/sherpa-onnx-sense-voice-zh-en-ja-ko-yue-2024-07-17';

  final senseVoiceConfig = sherpa_onnx.OfflineSenseVoiceModelConfig(
    model: await copyAssetFile('$modelDir/model.int8.onnx'), // 用户要求使用int8模型
    language: '', // 空字符串表示自动检测语言
    useInverseTextNormalization: true, // 🎯 关键：启用标点符号处理
  );

  final modelConfig = sherpa_onnx.OfflineModelConfig(
    senseVoice: senseVoiceConfig,
    tokens: await copyAssetFile('$modelDir/tokens.txt'),
    modelType: 'sense_voice',
    numThreads: 2, // 🎯 反编译APK使用2线程，不是1线程
  );

  final config = sherpa_onnx.OfflineRecognizerConfig(
    model: modelConfig,
    // 🎯 添加反编译APK中的关键配置
    decodingMethod: 'greedy_search',
    maxActivePaths: 4,
  );

  return sherpa_onnx.OfflineRecognizer(config);
}

// 🔧 优化VAD配置 - 基于反编译APK分析
Future<sherpa_onnx.VoiceActivityDetector> createVAD() async {
  final sileroVadConfig = sherpa_onnx.SileroVadModelConfig(
    model: await copyAssetFile('assets/silero_vad.onnx'),
    minSilenceDuration: 0.5, // 🎯 调整参数提高实时性
    minSpeechDuration: 0.25, // 🎯 减少最小语音时长
    maxSpeechDuration: 10.0, // 🎯 增加最大语音时长
    threshold: 0.5, // 🎯 添加阈值配置
  );

  final vadConfig = sherpa_onnx.VadModelConfig(
    sileroVad: sileroVadConfig,
    sampleRate: 16000,
    numThreads: 2, // 🎯 VAD也使用2线程
  );

  return sherpa_onnx.VoiceActivityDetector(
      config: vadConfig, bufferSizeInSeconds: 30); // 🎯 增加缓冲区
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

  String _title = 'SenseVoice多语言实时识别 (修复版)';
  String _last = '';
  int _index = 0;
  bool _isInitialized = false;

  sherpa_onnx.OfflineRecognizer? _recognizer;
  sherpa_onnx.VoiceActivityDetector? _vad;
  int _sampleRate = 16000;

  StreamSubscription<RecordState>? _recordSub;
  RecordState _recordState = RecordState.stop;

  // 🎯 核心修复：采用反编译APK的Channel队列机制
  final Queue<Float32List> _audioQueue = Queue<Float32List>();
  StreamSubscription<List<int>>? _audioStreamSub;
  Timer? _processingTimer;

  // 🎯 避免重复处理的状态管理
  bool _isProcessing = false;

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
      print('🔄 正在初始化SenseVoice和VAD...');
      sherpa_onnx.initBindings();

      try {
        _recognizer = await createSenseVoiceRecognizer();
        _vad = await createVAD();
        _isInitialized = true;

        print('✅ SenseVoice识别器和VAD初始化成功');
      } catch (e) {
        print('❌ 初始化失败: $e');
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

        // 🎯 关键修复：严格按照反编译APK的架构
        final stream = await _audioRecorder.startStream(config);

        // 🎯 音频录制协程：模拟反编译APK的samplesChannel.send逻辑
        _audioStreamSub = stream.listen(
          (rawData) {
            _enqueueAudioData(rawData);
          },
          onDone: () {
            print('🔇 音频流停止');
          },
        );

        // 🎯 音频处理协程：从队列取数据处理，避免重复
        _processingTimer = Timer.periodic(
          const Duration(milliseconds: 100), // 🔧 100ms处理间隔
          (_) => _processAudioQueue(),
        );
      }
    } catch (e) {
      print('❌ 启动录音失败: $e');
    }
  }

  // 🎯 新增：音频入队逻辑 (对应反编译APK的samplesChannel.send)
  void _enqueueAudioData(List<int> rawData) {
    try {
      // 转换为Float32List
      final samplesFloat32 = convertBytesToFloat32(Uint8List.fromList(rawData));

      // 🎯 关键：按照反编译APK，每0.1秒的数据作为一个单元
      const int chunkSize = 1600; // 16000 * 0.1 = 1600 samples

      for (int i = 0; i < samplesFloat32.length; i += chunkSize) {
        final end = (i + chunkSize < samplesFloat32.length)
            ? i + chunkSize
            : samplesFloat32.length;

        final chunk = Float32List.fromList(samplesFloat32.sublist(i, end));

        // 入队，限制队列大小避免内存泄漏
        _audioQueue.add(chunk);

        // 保持队列大小合理 (最多30秒数据)
        while (_audioQueue.length > 300) {
          // 30秒 / 0.1秒 = 300块
          _audioQueue.removeFirst();
        }
      }
    } catch (e) {
      print('音频入队失败: $e');
    }
  }

  // 🎯 新增：音频队列处理逻辑 (对应反编译APK的Channel.receive逻辑)
  void _processAudioQueue() {
    if (_isProcessing ||
        _audioQueue.isEmpty ||
        _vad == null ||
        _recognizer == null) {
      return;
    }

    _isProcessing = true;

    try {
      // 🎯 关键：每次只处理队列中的新数据，避免重复
      final List<Float32List> currentBatch = [];

      // 取出所有待处理的音频块
      while (_audioQueue.isNotEmpty && currentBatch.length < 10) {
        // 最多处理1秒数据
        currentBatch.add(_audioQueue.removeFirst());
      }

      if (currentBatch.isEmpty) {
        _isProcessing = false;
        return;
      }

      // 🎯 合并音频块进行VAD处理
      final List<double> combinedAudio = [];
      for (final chunk in currentBatch) {
        combinedAudio.addAll(chunk);
      }

      final Float32List samples = Float32List.fromList(combinedAudio);

      // VAD处理
      _vad!.acceptWaveform(samples);

      // 🎯 关键：只有当VAD检测到完整语音段时才进行识别
      while (!_vad!.isEmpty()) {
        final speechSegment = _vad!.front();
        _vad!.pop();

        _processCompleteSpeechSegment(speechSegment);
      }
    } catch (e) {
      print('❌ 队列处理失败: $e');
    } finally {
      _isProcessing = false;
    }
  }

  // 🎯 处理完整语音段 (单次识别，无重复)
  void _processCompleteSpeechSegment(dynamic speechSegment) {
    try {
      final stream = _recognizer!.createStream();
      stream.acceptWaveform(
          samples: speechSegment.samples, sampleRate: _sampleRate);

      _recognizer!.decode(stream);
      final result = _recognizer!.getResult(stream);
      final text = result.text.trim();

      if (text.isNotEmpty) {
        _updateFinalText(text);
      }

      stream.free();
    } catch (e) {
      print('语音段识别错误: $e');
    }
  }

  // 🎯 最终文本更新 (确保不重复)
  void _updateFinalText(String text) {
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

    print('✅ 识别结果: $text'); // 调试日志
  }

  Future<void> _stop() async {
    _audioStreamSub?.cancel();
    _processingTimer?.cancel();
    _audioQueue.clear();
    _isProcessing = false;
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
          backgroundColor: Colors.orange[700], // 🎯 橙色表示修复版
          foregroundColor: Colors.white,
        ),
        body: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Container(
              padding: const EdgeInsets.all(16),
              margin: const EdgeInsets.all(16),
              decoration: BoxDecoration(
                color: Colors.orange[50], // 🎯 配色更新
                borderRadius: BorderRadius.circular(8),
                border: Border.all(color: Colors.orange[200]!),
              ),
              child: Column(
                children: [
                  const Icon(Icons.build_circle,
                      color: Colors.orange), // 🎯 修复图标
                  const SizedBox(height: 8),
                  const Text(
                    'SenseVoice多语言模型 (修复版)',
                    style: TextStyle(fontWeight: FontWeight.bold),
                  ),
                  const SizedBox(height: 4),
                  const Text(
                    '🔧 修复重复识别 | ✨ 标点符号 | 📋 队列机制',
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
                    hintText: '说话完整句子后会显示识别结果...',
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
    _audioStreamSub?.cancel();
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
