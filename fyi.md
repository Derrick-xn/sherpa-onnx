# FYI - AI开发过程记录

## 📋 **项目概述**
- **目标**: 基于反编译APK实现SenseVoice模拟流式ASR
- **平台**: Flutter -> React Native (最终目标)
- **核心挑战**: 复刻反编译APK的实时显示机制

---

## 🚨 **重大问题与解决**

### **问题1: 大量重复识别** (已解决 ✅)
**现象**: 说一句话输出"你好你好你好..."
**根因**: 错误的缓冲区处理，重复识别同样音频数据
**解决方案**: 实现队列机制，确保每个音频块只处理一次

### **问题2: 实时显示缺失** (已解决 ✅)  
**现象**: 必须停顿才能看到结果，无法边说边显示
**根因**: 未正确复刻反编译APK的双协程架构
**解决方案**: 完全重构为双协程+滑动窗口架构

---

## 🔄 **架构演进历史**

### **第一版: 基础实现**
```dart
❌ 单Timer处理 -> 重复识别问题
Timer.periodic() -> _processBuffer()
```

### **第二版: 队列修复**  
```dart
✅ Queue<Float32List> -> 避免重复
_audioQueue.removeFirst() -> 单次处理
```

### **第三版: 实时重构** (当前版本)
```dart
🚀 双协程架构 -> 真正实时显示
AnonymousClass1: _samplesChannel.add()
AnonymousClass2: _processAudioChunkRealtime()
```

---

## 🎯 **技术突破点**

### **双协程架构复刻**:
```
反编译APK架构:
├── AnonymousClass1 (Dispatchers.IO)
│   └── samplesChannel.send(floatSamples) // 每0.1秒
├── AnonymousClass2 (Dispatchers.Default)  
│   ├── samplesChannel.receive() // 实时接收
│   ├── 滑动窗口处理 (buffer + offset)
│   └── 实时文本更新

Flutter实现:
├── _startAudioRecordingCoroutine()
│   └── _samplesChannel.add(chunk) // 模拟send
├── _startAudioProcessingCoroutine()
│   ├── _samplesChannel.stream.listen() // 模拟receive  
│   ├── _processAudioChunkRealtime() // 滑动窗口
│   └── _updatePartialText() // 实时显示
```

### **滑动窗口实时识别**:
```dart
// 关键创新：不等VAD，直接实时识别
_processRealtimeRecognition() {
  final windowAudio = _audioBuffer.sublist(
    math.max(0, _audioBuffer.length - _windowSize)
  );
  // 实时识别 -> 边说边显示
}
```

### **双层文本显示机制**:
```dart
_currentPartialText  // 实时部分结果 (识别中...)
_resultList         // 最终确认结果
```

---

## 📊 **版本对比**

| 特性 | 队列版 (第二版) | 实时版 (第三版) |
|------|---------------|---------------|
| 重复识别 | ✅ 已修复 | ✅ 已修复 |
| 实时显示 | ❌ 需要停顿 | ✅ 边说边显示 |
| 架构 | 单Timer处理 | 双协程并行 |
| 窗口机制 | 队列FIFO | 滑动窗口 |
| 用户体验 | 断续识别 | 流畅实时 |

---

## 🔧 **关键配置参数**

### **模型配置**:
```dart
useInverseTextNormalization: true  // 标点符号
numThreads: 2                      // 双线程
model: 'model.int8.onnx'          // 压缩模型
```

### **实时参数**:
```dart
_windowSize = 8000        // 0.5秒滑动窗口
chunkSize = 1600         // 0.1秒音频块
minSpeechDuration: 0.25  // VAD最小语音时长
```

---

## ✅ **最终成果**

### **APK信息**:
- **位置**: `build/app/outputs/flutter-apk/app-release.apk`
- **大小**: 615.7MB
- **特性**: 双协程实时识别

### **核心能力**:
- ⚡ **边说边显示**: 无需停顿的实时输出
- 📝 **标点符号**: 完整ITN处理  
- 🌐 **多语言**: 中英日韩粤混合
- 🔄 **无重复**: 解决重复识别问题
- 🎯 **高精度**: SenseVoice大模型支持

---

## 📝 **经验总结**

### **技术教训**:
1. **架构比优化更重要**: 错误架构无法通过参数调优解决
2. **严格复刻**: 反编译代码的每个细节都有存在意义
3. **协程并发**: 音频处理必须采用生产者-消费者模式

### **调试技巧**:
1. **日志分层**: 分别记录录制协程和处理协程
2. **状态跟踪**: 监控缓冲区大小和处理频率  
3. **边界测试**: 验证连续语音和静音切换

---

## 🚀 **下一步计划**
1. **性能测试**: 长时间使用稳定性
2. **React Native迁移**: 核心架构移植
3. **产品集成**: 整合到实际项目

---
*记录时间: 2024年最新*
*状态: 实时版本开发完成 ✅* 