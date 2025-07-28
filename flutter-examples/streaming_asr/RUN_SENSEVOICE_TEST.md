# 🎙️ SenseVoice实时识别测试指南 (实时版)

## 📱 **APK信息**
- **位置**: `/Users/zouxinnan/Desktop/yxbjwp/sherpa-onnx/flutter-examples/streaming_asr/build/app/outputs/flutter-apk/app-release.apk`
- **版本**: 实时版 (双协程架构)
- **大小**: 615.7MB  
- **应用名**: "SenseVoice ASR"

## 🚀 **重大技术突破**

### **双协程架构**：
```
AnonymousClass1 (录制协程)  ──samplesChannel──>  AnonymousClass2 (处理协程)
     ↓                                                ↓
   0.1秒音频块                                    实时识别+显示
```

### **核心特性**：
- ⚡ **边说边显示**：无需停顿，实时输出
- 🎯 **滑动窗口**：0.5秒窗口实时识别  
- 📝 **标点符号**：完整的ITN处理
- 🌐 **多语言**：中英日韩粤语混合

## 🧪 **关键测试项目**

### **1. 实时显示测试 ⚡**
- **目标**: 验证边说边显示效果
- **测试**: 说长句子，观察是否**边说边出现文字**
- **预期**: 
  - ✅ 说话过程中即显示"(识别中...)"
  - ✅ 不需要明显停顿
  - ✅ 文字随说话实时更新

### **2. 标点符号测试 📝**  
- **测试语句**:
  ```
  你好，我是小明。今天天气怎么样？很不错！
  Hello, how are you? I'm fine, thank you.
  ```
- **预期**: ✅ 逗号、句号、问号、感叹号正确显示

### **3. 多语言混合测试 🌐**
- **测试语句**:
  ```
  我想说hello，你好world，今天はいい天気ですね。
  这是一个test，测试多语言support。
  ```
- **预期**: ✅ 中英日混合正确识别

### **4. 连续语音测试 🔄**
- **测试**: 连续说3-5句话，不停顿
- **预期**: 
  - ✅ 每句话分别显示为独立结果
  - ✅ 实时更新不重复
  - ✅ 最终结果准确完整

### **5. 性能压力测试 ⚡**
- **测试**: 快速连续说话1-2分钟
- **预期**:
  - ✅ 应用不卡顿
  - ✅ 内存稳定
  - ✅ 实时性保持

## ⚠️ **已知优化点**
- **初始化时间**: 约3-5秒（使用int8模型的权衡）
- **内存占用**: ~600MB（SenseVoice大模型）

## 🔧 **技术改进说明**

### **架构重构**:
```dart
// 之前：单一处理循环 -> 重复识别问题
Timer.periodic() -> _processBuffer() // ❌

// 现在：双协程架构 -> 真正实时
_samplesChannel.stream.listen() -> _processAudioChunkRealtime() // ✅
```

### **实时机制**:
```dart
// 滑动窗口实时识别
_processRealtimeRecognition() {
  final windowAudio = _audioBuffer.sublist(max(0, length - _windowSize));
  // 实时识别 -> _updatePartialText()
}

// VAD完整段处理  
_processRealtimeVAD() {
  // 完整语音段 -> _addFinalResult()
}
```

## 📋 **测试检查清单**
- [ ] **实时显示**: 边说边显示，无需停顿
- [ ] **标点符号**: 逗号句号问号感叹号
- [ ] **多语言**: 中英日韩粤混合识别
- [ ] **无重复**: 不出现"你好你好你好"现象
- [ ] **连续识别**: 多句话连续处理
- [ ] **性能稳定**: 长时间使用不卡顿

---
**测试完成后请反馈结果！** 🚀 