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

// 🔧 完全复刻反编译APK的SenseVoice配置
Future<sherpa_onnx.OfflineRecognizer> createSenseVoiceRecognizer() async {
  final modelDir =
      'assets/models/sherpa-onnx-sense-voice-zh-en-ja-ko-yue-2024-07-17';

  final senseVoiceConfig = sherpa_onnx.OfflineSenseVoiceModelConfig(
    model: await copyAssetFile('$modelDir/model.int8.onnx'),
    language: '', // 空字符串表示自动检测语言
    useInverseTextNormalization: true,
  );

  final modelConfig = sherpa_onnx.OfflineModelConfig(
    senseVoice: senseVoiceConfig,
    tokens: await copyAssetFile('$modelDir/tokens.txt'),
    modelType: 'sense_voice',
    numThreads: 2, // 🎯 严格复刻：反编译APK强制设置为2线程
    debug: false,
  );

  final config = sherpa_onnx.OfflineRecognizerConfig(
    model: modelConfig,
    decodingMethod: 'greedy_search',
    maxActivePaths: 4,
  );

  return sherpa_onnx.OfflineRecognizer(config);
}

// 🔧 完全复刻反编译APK的VAD配置
Future<sherpa_onnx.VoiceActivityDetector> createVAD() async {
  final sileroVadConfig = sherpa_onnx.SileroVadModelConfig(
    model: await copyAssetFile('assets/silero_vad.onnx'),
    minSilenceDuration: 0.5, // 🎯 复刻反编译APK: 0.5f
    minSpeechDuration: 0.25, // 🎯 复刻反编译APK: 0.25f
    maxSpeechDuration: 8.0,
    threshold: 0.45,
  );

  final vadConfig = sherpa_onnx.VadModelConfig(
    sileroVad: sileroVadConfig,
    sampleRate: 16000,
    numThreads: 1, // 🎯 严格复刻：反编译APK的VAD默认使用1线程
  );

  return sherpa_onnx.VoiceActivityDetector(
      config: vadConfig, bufferSizeInSeconds: 20);
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

  String _title = 'SenseVoice多语言实时识别 (严格复刻版)';
  String _last = '';
  int _index = 0;
  bool _isInitialized = false;
  String _initStatus = '准备初始化...';

  sherpa_onnx.OfflineRecognizer? _recognizer;
  sherpa_onnx.VoiceActivityDetector? _vad;
  int _sampleRate = 16000;

  StreamSubscription<RecordState>? _recordSub;
  RecordState _recordState = RecordState.stop;

  // 🎯 音频处理通道
  StreamController<Float32List> _samplesChannel =
      StreamController<Float32List>.broadcast();

  // 🎯 状态变量
  List<double> _buffer = [];
  String _lastText = '';
  int _offset = 0;
  int _windowSize = 6400; // 🎯 减小窗口大小 (0.4秒)
  bool _isSpeechStarted = false;
  int _startTime = 0;
  bool _added = false;

  // 🎯 改进的文本显示机制
  List<String> _resultList = [];
  String _currentPartialText = '';
  String _lastStableText = ''; // 🎯 上一个稳定的文本
  int _stableCounter = 0; // 🎯 稳定计数器
  Timer? _updateTimer; // 🎯 更新定时器

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

    // 🎯 预初始化以减少启动时间
    _preInitialize();

    super.initState();
  }

  // 🎯 预初始化模型
  Future<void> _preInitialize() async {
    setState(() {
      _initStatus = '正在初始化SenseVoice...';
    });

    try {
      sherpa_onnx.initBindings();

      setState(() {
        _initStatus = '正在加载模型文件...';
      });

      _recognizer = await createSenseVoiceRecognizer();

      setState(() {
        _initStatus = '正在初始化VAD...';
      });

      _vad = await createVAD();

      setState(() {
        _isInitialized = true;
        _initStatus = '✅ 初始化完成';
      });

      print('✅ 预初始化完成');
    } catch (e) {
      setState(() {
        _initStatus = '❌ 初始化失败: $e';
      });
      print('❌ 预初始化失败: $e');
    }
  }

  Future<void> _start() async {
    if (!_isInitialized) {
      setState(() {
        _initStatus = '请等待初始化完成...';
      });
      return;
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

        // 🎯 启动双协程
        _startAnonymousClass1(stream);
        _startAnonymousClass2();
      }
    } catch (e) {
      print('❌ 启动录音失败: $e');
    }
  }

  // 🎯 AnonymousClass1: 音频录制协程
  void _startAnonymousClass1(Stream<List<int>> audioStream) {
    print('🎙️ sherpa-onnx-sim-asr: processing samples');

    const int chunkSize = 1600; // 0.1秒音频块

    _audioStreamSub = audioStream.listen(
      (rawData) {
        try {
          final bytes = Uint8List.fromList(rawData);
          final shortBuffer = bytes.buffer.asInt16List();

          for (int i = 0; i < shortBuffer.length; i += chunkSize) {
            final end = (i + chunkSize < shortBuffer.length)
                ? i + chunkSize
                : shortBuffer.length;

            final shortChunk = shortBuffer.sublist(i, end);

            final floatChunk = Float32List(shortChunk.length);
            for (int j = 0; j < shortChunk.length; j++) {
              floatChunk[j] = shortChunk[j] / 32768.0;
            }

            if (!_samplesChannel.isClosed) {
              _samplesChannel.add(floatChunk);
            }
          }
        } catch (e) {
          print('AnonymousClass1错误: $e');
        }
      },
      onDone: () {
        print('🔇 AnonymousClass1停止');
      },
    );
  }

  // 🎯 AnonymousClass2: 音频处理协程
  void _startAnonymousClass2() {
    print('🔄 sherpa-onnx-sim-asr: 启动AnonymousClass2');

    // 重置状态变量
    _buffer.clear();
    _lastText = '';
    _lastStableText = '';
    _stableCounter = 0;
    _offset = 0;
    _windowSize = 6400; // 0.4秒窗口
    _isSpeechStarted = false;
    _startTime = DateTime.now().millisecondsSinceEpoch;
    _added = false;
    _vad?.reset();

    _processingStreamSub = _samplesChannel.stream.listen(
      (floatSamples) {
        _processAnonymousClass2Logic(floatSamples);
      },
      onDone: () {
        print('🔇 AnonymousClass2停止');
      },
    );
  }

  // 🎯 核心：AnonymousClass2的处理逻辑
  void _processAnonymousClass2Logic(Float32List floatSamples) {
    try {
      _buffer.addAll(floatSamples);

      // 🎯 VAD处理 - 主要用于检测完整语音段
      if (_buffer.length >= 1600) {
        _vad?.acceptWaveform(Float32List.fromList(
            _buffer.sublist(math.max(0, _buffer.length - 1600))));

        // 🎯 处理VAD检测到的完整语音段
        while (_vad?.isEmpty() == false) {
          final speechSegment = _vad?.front();
          _vad?.pop();

          if (speechSegment != null) {
            _processFinalSpeechSegment(speechSegment);
          }
        }
      }

      // 🎯 滑动窗口机制
      if (_buffer.length > _windowSize * 3) {
        final newOffset = _buffer.length - _windowSize;
        _buffer = _buffer.sublist(newOffset);
        _offset = newOffset;
      }

      // 🎯 优化的实时识别 - 减少频率避免跳动
      if (_buffer.length >= _windowSize && _buffer.length % 800 == 0) {
        _performStableRealtimeRecognition();
      }
    } catch (e) {
      print('AnonymousClass2处理错误: $e');
    }
  }

  // 🎯 完整语音段处理（高质量识别）
  void _processFinalSpeechSegment(dynamic speechSegment) {
    try {
      final stream = _recognizer!.createStream();
      stream.acceptWaveform(
          samples: speechSegment.samples, sampleRate: _sampleRate);

      _recognizer!.decode(stream);
      final result = _recognizer!.getResult(stream);
      final text = result.text.trim();

      if (text.isNotEmpty && text.length > 1) {
        // 🎯 过滤太短的结果
        _addToResultList(text);
      }

      stream.free();
    } catch (e) {
      print('语音段处理错误: $e');
    }
  }

  // 🎯 稳定的实时识别（减少跳动）
  void _performStableRealtimeRecognition() {
    try {
      if (_recognizer == null || _buffer.length < _windowSize) return;

      final windowStart = math.max(0, _buffer.length - _windowSize);
      final windowAudio = Float32List.fromList(_buffer.sublist(windowStart));

      final stream = _recognizer!.createStream();
      stream.acceptWaveform(samples: windowAudio, sampleRate: _sampleRate);

      _recognizer!.decode(stream);
      final result = _recognizer!.getResult(stream);
      final text = result.text.trim();

      // 🎯 稳定性检查 - 减少文字跳动
      if (text.isNotEmpty && text.length > 1) {
        if (text == _lastStableText) {
          _stableCounter++;
          if (_stableCounter >= 2) {
            // 🎯 连续2次相同才显示
            _updateRealtimeTextStable(text);
          }
        } else {
          _lastStableText = text;
          _stableCounter = 1;
        }
      }

      stream.free();
    } catch (e) {
      print('实时识别错误: $e');
    }
  }

  // 🎯 稳定的实时文本更新（减少跳动）
  void _updateRealtimeTextStable(String text) {
    if (text == _lastText) return; // 避免重复更新

    setState(() {
      _currentPartialText = text;
      _lastText = text;

      // 🎯 改进的显示格式 - 去掉"(识别中...)"
      String displayText = '';
      for (int i = 0; i < _resultList.length; i++) {
        displayText += '${i + 1}: ${_resultList[i]}\n';
      }

      // 🎯 简洁的当前识别显示
      if (_currentPartialText.isNotEmpty) {
        displayText += '${_resultList.length + 1}: $_currentPartialText';
      }

      _controller.value = TextEditingValue(
        text: displayText,
        selection: TextSelection.collapsed(offset: displayText.length),
      );
    });
  }

  // 🎯 添加到结果列表
  void _addToResultList(String text) {
    setState(() {
      _resultList.add(text);
      _currentPartialText = ''; // 清空部分结果
      _lastText = '';
      _lastStableText = '';
      _stableCounter = 0;

      String displayText = '';
      for (int i = 0; i < _resultList.length; i++) {
        displayText += '${i + 1}: ${_resultList[i]}';
        if (i < _resultList.length - 1) displayText += '\n';
      }

      _controller.value = TextEditingValue(
        text: displayText,
        selection: TextSelection.collapsed(offset: displayText.length),
      );
    });

    print('✅ 最终结果 ${_resultList.length}: $text');
  }

  Future<void> _stop() async {
    _audioStreamSub?.cancel();
    _processingStreamSub?.cancel();
    _samplesChannel.close();
    _updateTimer?.cancel();

    // 重新创建channel为下次使用
    _samplesChannel = StreamController<Float32List>.broadcast();

    // 重置状态变量
    _buffer.clear();
    _currentPartialText = '';
    _lastText = '';
    _lastStableText = '';
    _stableCounter = 0;
    _offset = 0;
    _isSpeechStarted = false;
    _added = false;

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
          backgroundColor: Colors.purple[700], // 🎯 紫色表示严格复刻版
          foregroundColor: Colors.white,
        ),
        body: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Container(
              padding: const EdgeInsets.all(16),
              margin: const EdgeInsets.all(16),
              decoration: BoxDecoration(
                color: Colors.purple[50], // 🎯 配色更新
                borderRadius: BorderRadius.circular(8),
                border: Border.all(color: Colors.purple[200]!),
              ),
              child: Column(
                children: [
                  const Icon(Icons.verified, color: Colors.purple), // 🎯 验证图标
                  const SizedBox(height: 8),
                  const Text(
                    'SenseVoice严格复刻版',
                    style: TextStyle(fontWeight: FontWeight.bold),
                  ),
                  const SizedBox(height: 4),
                  const Text(
                    '🎯 Recognizer: 2线程 | 🔧 VAD: 1线程 | 📋 严格按反编译APK',
                    style: TextStyle(fontSize: 12, color: Colors.grey),
                  ),
                  const SizedBox(height: 4),
                  Text(
                    _initStatus,
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
                  decoration: InputDecoration(
                    border: InputBorder.none,
                    hintText: _isInitialized
                        ? '开始说话，严格复刻反编译APK的实时识别...'
                        : '正在初始化，请稍候...',
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
    _updateTimer?.cancel();
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
      icon = Icon(Icons.mic,
          color: _isInitialized ? theme.primaryColor : Colors.grey, size: 30);
      color = _isInitialized
          ? theme.primaryColor.withOpacity(0.1)
          : Colors.grey.withOpacity(0.1);
    }

    return ClipOval(
      child: Material(
        color: color,
        child: InkWell(
          child: SizedBox(width: 56, height: 56, child: icon),
          onTap: _isInitialized
              ? () => (_recordState != RecordState.stop) ? _stop() : _start()
              : null,
        ),
      ),
    );
  }

  Widget _buildText() {
    if (!_isInitialized) {
      return const Text("初始化中...");
    } else if (_recordState == RecordState.stop) {
      return const Text("开始录音");
    } else {
      return const Text("停止录音");
    }
  }
}
