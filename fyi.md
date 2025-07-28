# Sherpa-ONNX APK 流式识别实现技术分析

## 概述
反编译的 `sherpa-onnx-1.12.4-arm64-v8a-simulated_streaming_asr-zh_en_ko_ja_yue-sense_voice.apk` 显示这是一个**模拟流式识别**的应用，而非真正的流式识别。它使用离线模型来模拟流式效果。

## 核心架构组件

### 1. 主要技术栈
- **应用框架**: Android + Kotlin + Jetpack Compose
- **推理引擎**: ONNX Runtime
- **模型**: SenseVoice 多语言模型（中英日韩粤）
- **VAD模型**: Silero VAD
- **音频处理**: AudioRecord API

### 2. 关键文件结构
```
com.k2fsa.sherpa.onnx.simulate.streaming.asr/
├── SimulateStreamingAsr.java          # 核心管理类
├── MainActivity.java                  # 主入口
├── screens/HomeKt.java               # 用户界面和音频处理
├── OfflineRecognizer.java            # 离线识别器
├── Vad.java                          # 语音活动检测
└── 各种配置类

assets/
├── silero_vad.onnx                   # VAD模型(1.7MB)
├── sherpa-onnx-sense-voice-zh-en-ja-ko-yue-2024-07-17/
│   ├── model.int8.onnx              # SenseVoice模型(228MB)
│   └── tokens.txt                   # 词汇表(25,056个token)
├── lexicon.txt                       # 词典文件(1.3MB)
└── replace.fst                       # 文本后处理规则

lib/arm64-v8a/
├── libsherpa-onnx-jni.so            # JNI本地库(3.5MB)
├── libonnxruntime.so                # ONNX Runtime(15MB)
└── libandroidx.graphics.path.so     # Android图形库
```

## 流式识别实现机制详解

### 1. "模拟流式"的工作原理

**关键发现**: 这个应用名为"simulate streaming asr"，实际上是用离线模型模拟流式效果，而非真正的流式识别。

#### 音频采集流程：
```kotlin
// 音频参数设置
sampleRateInHz = 16000  // 16kHz采样率
bufferSize = 1600       // 0.1秒的音频数据(16000 * 0.1)

// 音频采集循环（来自HomeKt.java第200-300行）
while (isStarted) {
    audioRecord.read(buffer, 0, buffer.length)  // 读取音频数据
    
    // 转换为float格式（归一化到[-1,1]）
    for (int i = 0; i < samples; i++) {
        floatSamples[i] = buffer[i] / 32768.0f
    }
    
    samplesChannel.send(floatSamples)  // 发送到处理通道
}
```

### 2. VAD（语音活动检测）机制

```java
// VAD初始化（SimulateStreamingAsr.java第89行）
VadModelConfig vadConfig = VadKt.getVadModelConfig(0);  // 使用Silero VAD
Vad vad = new Vad(assetManager, vadConfig);

// VAD处理流程
vad.acceptWaveform(audioSamples);           // 输入音频
boolean isSpeech = vad.isSpeechDetected();  // 检测是否为语音
if (!vad.empty()) {
    SpeechSegment segment = vad.front();    // 获取语音段
    vad.pop();                              // 移除已处理的段
}
```

### 3. 识别引擎配置

#### SenseVoice模型配置：
```java
// 模型类型15对应SenseVoice（SimulateStreamingAsr.java第68行）
OfflineModelConfig modelConfig = OfflineRecognizerKt.getOfflineModelConfig(15);

// SenseVoice特定配置
OfflineSenseVoiceModelConfig senseVoiceConfig = new OfflineSenseVoiceModelConfig(
    "model.int8.onnx",    // 量化模型文件
    "",                   // 语言（自动检测）
    false                 // 不使用逆文本规范化
);
```

#### 同音字替换配置：
```java
HomophoneReplacerConfig hrConfig = new HomophoneReplacerConfig(
    "dict",           // 字典目录
    "lexicon.txt",    // 词典文件
    "replace.fst"     // 替换规则FST
);
```

### 4. 识别流程

#### 离线识别器工作流程：
```java
// 创建识别器（SimulateStreamingAsr.java第76行）
OfflineRecognizer recognizer = new OfflineRecognizer(assetManager, config);

// 识别流程
OfflineStream stream = recognizer.createStream();  // 创建流
recognizer.decode(stream);                         // 解码
OfflineRecognizerResult result = recognizer.getResult(stream);  // 获取结果
```

### 5. 多语言支持

**支持语言**: 中文、英文、日文、韩文、粤语
- **词汇表**: 25,056个token，支持多语言混合识别
- **模型**: SenseVoice-small量化版本（int8）
- **语言检测**: 自动识别输入语言

### 6. 性能优化策略

#### 模型优化：
- **量化**: 使用int8量化降低模型大小（228MB）
- **线程**: 默认2线程并行处理
- **内存**: 使用流式处理减少内存占用

#### 音频处理优化：
- **缓冲**: 100ms音频块处理
- **异步**: 使用Kotlin协程异步处理
- **通道**: 使用Channel进行音频数据流转

## 技术特点总结

### 优势：
1. **离线运行**: 无需网络连接
2. **多语言**: 支持5种语言混合识别
3. **实时性**: 100ms延迟的准实时处理
4. **准确性**: 基于先进的SenseVoice模型
5. **资源优化**: int8量化减少资源消耗

### 局限性：
1. **伪流式**: 实际上是分段离线识别
2. **延迟**: 相比真正的流式识别有额外延迟
3. **资源**: 模型文件较大（230MB+）
4. **实时性**: 依赖VAD准确性，可能有漏检

## 关键技术实现细节

### 1. JNI接口设计
```java
// 所有核心功能都通过JNI调用C++实现
private native long newFromAsset(AssetManager, OfflineRecognizerConfig);
private native void decode(long ptr, long streamPtr);
private native Object[] getResult(long streamPtr);
```

### 2. 内存管理
```java
// 使用指针管理C++对象生命周期
protected void finalize() {
    if (ptr != 0) {
        delete(ptr);  // 释放C++对象
        ptr = 0L;
    }
}
```

### 3. 错误处理
- 全面的空指针检查
- 异常捕获和日志记录
- 资源清理保证

这个实现展示了如何在移动端实现高质量的离线语音识别，虽然不是真正的流式识别，但通过巧妙的设计实现了接近流式的用户体验。 