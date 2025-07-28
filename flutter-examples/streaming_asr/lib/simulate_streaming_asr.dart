// Copyright (c)  2024  Xiaomi Corporation
import 'dart:async';
import 'dart:typed_data';
import 'dart:collection';
import 'dart:isolate';
import 'dart:math' as math;

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

  String _title = 'SenseVoice多语言实时识别 (实时版)';
  String _last = '';
  int _index = 0;
  bool _isInitialized = false;

  sherpa_onnx.OfflineRecognizer? _recognizer;
  sherpa_onnx.VoiceActivityDetector? _vad;
  int _sampleRate = 16000;

  StreamSubscription<RecordState>? _recordSub;
  RecordState _recordState = RecordState.stop;

  // 🎯 关键修复：严格按照反编译APK的双协程架构
  // AnonymousClass1: 音频录制协程（对应samplesChannel.send）
  StreamController<Float32List> _samplesChannel =
      StreamController<Float32List>.broadcast();

  // AnonymousClass2: 音频处理协程状态变量（严格按反编译APK）
  List<double> _audioBuffer = [];
  String _lastText = '';
  int _offset = 0;
  int _windowSize = 8000; // 0.5秒窗口
  bool _isSpeechStarted = false;
  int _startTime = 0;
  bool _added = false;

  // 实时文本显示
  List<String> _resultList = [];
  String _currentPartialText = '';

  // 协程控制
  StreamSubscription<List<int>>? _audioStreamSub;
  StreamSubscription<Float32List>? _processingStreamSub;

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

        // 🎯 重点：严格按照反编译APK的双协程架构
        final stream = await _audioRecorder.startStream(config);

        // 🎯 AnonymousClass1: 音频录制协程 (Dispatchers.IO)
        _startAudioRecordingCoroutine(stream);

        // 🎯 AnonymousClass2: 音频处理协程 (Dispatchers.Default)
        _startAudioProcessingCoroutine();
      }
    } catch (e) {
      print('❌ 启动录音失败: $e');
    }
  }

  // 🎯 AnonymousClass1: 音频录制协程（严格按反编译APK）
  void _startAudioRecordingCoroutine(Stream<List<int>> audioStream) {
    print('🎙️ 启动音频录制协程');

    _audioStreamSub = audioStream.listen(
      (rawData) {
        try {
          // 🎯 关键：按照反编译APK，每0.1秒的音频作为一个单元
          final samplesFloat32 =
              convertBytesToFloat32(Uint8List.fromList(rawData));

          // 分割为0.1秒的块（1600 samples = 16000 * 0.1）
          const int chunkSize = 1600;

          for (int i = 0; i < samplesFloat32.length; i += chunkSize) {
            final end = (i + chunkSize < samplesFloat32.length)
                ? i + chunkSize
                : samplesFloat32.length;

            final chunk = Float32List.fromList(samplesFloat32.sublist(i, end));

            // 🎯 关键：模拟samplesChannel.send(floatSamples)
            if (!_samplesChannel.isClosed) {
              _samplesChannel.add(chunk);
            }
          }
        } catch (e) {
          print('音频录制协程错误: $e');
        }
      },
      onDone: () {
        print('🔇 音频录制协程停止');
      },
    );
  }

  // 🎯 AnonymousClass2: 音频处理协程（严格按反编译APK的复杂逻辑）
  void _startAudioProcessingCoroutine() {
    print('🔄 启动音频处理协程');

    // 重置状态变量（按反编译APK）
    _audioBuffer.clear();
    _lastText = '';
    _offset = 0;
    _windowSize = 8000; // 0.5秒窗口
    _isSpeechStarted = false;
    _startTime = DateTime.now().millisecondsSinceEpoch;
    _added = false;
    _vad?.reset();

    _processingStreamSub = _samplesChannel.stream.listen(
      (audioChunk) {
        _processAudioChunkRealtime(audioChunk);
      },
      onDone: () {
        print('🔇 音频处理协程停止');
      },
    );
  }

  // 🎯 核心：实时音频处理（复刻反编译APK的复杂逻辑）
  void _processAudioChunkRealtime(Float32List audioChunk) {
    try {
      // 添加到滑动缓冲区
      _audioBuffer.addAll(audioChunk);

      // 🎯 关键：滑动窗口机制（模拟反编译APK的buffer+offset逻辑）
      if (_audioBuffer.length > _windowSize * 2) {
        // 保持窗口大小，移除旧数据
        _audioBuffer = _audioBuffer.sublist(_audioBuffer.length - _windowSize);
        _offset = _audioBuffer.length - _windowSize;
      }

      // 实时VAD处理
      if (_audioBuffer.length >= _windowSize ~/ 4) {
        // 足够的数据进行VAD
        _processRealtimeVAD();
      }

      // 🎯 关键：实时识别（不等待VAD完成）
      if (_audioBuffer.length >= _windowSize ~/ 2) {
        // 0.25秒数据
        _processRealtimeRecognition();
      }
    } catch (e) {
      print('实时音频处理错误: $e');
    }
  }

  // 🎯 实时VAD处理
  void _processRealtimeVAD() {
    try {
      if (_vad == null || _audioBuffer.length < 1600) return;

      // 取最近的音频进行VAD
      final recentAudio = Float32List.fromList(
          _audioBuffer.sublist(math.max(0, _audioBuffer.length - 1600)));

      _vad!.acceptWaveform(recentAudio);

      // 处理VAD检测到的语音段
      while (!_vad!.isEmpty()) {
        final speechSegment = _vad!.front();
        _vad!.pop();

        // 完整语音段识别
        _processFinalSpeechSegment(speechSegment);
      }
    } catch (e) {
      print('VAD处理错误: $e');
    }
  }

  // 🎯 实时识别（边说边显示的关键）
  void _processRealtimeRecognition() {
    try {
      if (_recognizer == null || _audioBuffer.length < 3200) return; // 0.2秒数据

      // 🎯 关键：滑动窗口实时识别
      final windowAudio = Float32List.fromList(
          _audioBuffer.sublist(math.max(0, _audioBuffer.length - _windowSize)));

      final stream = _recognizer!.createStream();
      stream.acceptWaveform(samples: windowAudio, sampleRate: _sampleRate);

      _recognizer!.decode(stream);
      final result = _recognizer!.getResult(stream);
      final text = result.text.trim();

      // 🎯 实时文本更新（边说边显示）
      if (text.isNotEmpty && text != _lastText) {
        _updatePartialText(text);
        _lastText = text;
      }

      stream.free();
    } catch (e) {
      print('实时识别错误: $e');
    }
  }

  // 🎯 完整语音段处理（最终结果）
  void _processFinalSpeechSegment(dynamic speechSegment) {
    try {
      final stream = _recognizer!.createStream();
      stream.acceptWaveform(
          samples: speechSegment.samples, sampleRate: _sampleRate);

      _recognizer!.decode(stream);
      final result = _recognizer!.getResult(stream);
      final text = result.text.trim();

      if (text.isNotEmpty) {
        _addFinalResult(text);
      }

      stream.free();
    } catch (e) {
      print('完整语音段处理错误: $e');
    }
  }

  // 🎯 实时文本更新（部分结果，边说边显示）
  void _updatePartialText(String text) {
    setState(() {
      _currentPartialText = text;

      // 显示当前的部分结果和历史结果
      String displayText = '';
      for (int i = 0; i < _resultList.length; i++) {
        displayText += '$i: ${_resultList[i]}\n';
      }

      // 添加当前正在识别的文本
      if (_currentPartialText.isNotEmpty) {
        displayText += '${_resultList.length}: $_currentPartialText (识别中...)';
      }

      _controller.value = TextEditingValue(
        text: displayText,
        selection: TextSelection.collapsed(offset: displayText.length),
      );
    });
  }

  // 🎯 添加最终结果
  void _addFinalResult(String text) {
    setState(() {
      _resultList.add(text);
      _currentPartialText = ''; // 清空部分结果

      // 更新显示
      String displayText = '';
      for (int i = 0; i < _resultList.length; i++) {
        displayText += '$i: ${_resultList[i]}';
        if (i < _resultList.length - 1) displayText += '\n';
      }

      _controller.value = TextEditingValue(
        text: displayText,
        selection: TextSelection.collapsed(offset: displayText.length),
      );
    });

    print('✅ 最终结果: $text');
  }

  Future<void> _stop() async {
    _audioStreamSub?.cancel();
    _processingStreamSub?.cancel();
    _samplesChannel.close();

    // 重新创建channel为下次使用
    _samplesChannel = StreamController<Float32List>.broadcast();

    _audioBuffer.clear();
    _currentPartialText = '';
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
          backgroundColor: Colors.blue[700], // 🎯 蓝色表示实时版
          foregroundColor: Colors.white,
        ),
        body: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Container(
              padding: const EdgeInsets.all(16),
              margin: const EdgeInsets.all(16),
              decoration: BoxDecoration(
                color: Colors.blue[50], // 🎯 配色更新
                borderRadius: BorderRadius.circular(8),
                border: Border.all(color: Colors.blue[200]!),
              ),
              child: Column(
                children: [
                  const Icon(Icons.mic_external_on,
                      color: Colors.blue), // 🎯 实时图标
                  const SizedBox(height: 8),
                  const Text(
                    'SenseVoice多语言模型 (实时版)',
                    style: TextStyle(fontWeight: FontWeight.bold),
                  ),
                  const SizedBox(height: 4),
                  const Text(
                    '🎙️ 双协程架构 | ⚡ 边说边显示 | 🎯 滑动窗口',
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
                    hintText: '开始说话，实时识别结果将边说边显示...',
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
    _processingStreamSub?.cancel();
    _samplesChannel.close();
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
