# FYI 文档 - AI开发过程记录

## 2024-07-28 - SenseVoice模拟流式ASR重复识别问题修复

### 问题描述
用户测试Flutter版SenseVoice应用时发现严重问题：
- 说一句话输出大量重复内容
- 例如："你好"重复输出几十遍
- 严重影响使用体验

### 问题根因分析
通过深入分析反编译APK的音频处理架构发现：

1. **反编译APK的正确架构**：
   - 使用`Channel<float[]>`队列机制
   - 音频录制协程将0.1秒音频块发送到队列
   - 独立的音频处理协程从队列接收数据
   - 每个音频块只处理一次

2. **Flutter实现的错误**：
   - 每50ms对整个音频缓冲区进行识别
   - 重复处理相同的音频数据
   - 没有队列机制，导致重复识别

### 修复方案
完全重写音频处理架构：

```dart
// 🎯 核心修复：队列机制
final Queue<Float32List> _audioQueue = Queue<Float32List>();

// 音频录制：入队新数据
void _enqueueAudioData(List<int> rawData) {
  // 按0.1秒切块入队
  const int chunkSize = 1600; // 16000 * 0.1
  audioQueue.add(chunk);
}

// 音频处理：从队列取数据处理
void _processAudioQueue() {
  while (_audioQueue.isNotEmpty) {
    final chunk = _audioQueue.removeFirst();
    processOnce(chunk); // 只处理一次
  }
}
```

### 关键技术要点
1. **防重复机制**：`_isProcessing`标志
2. **队列管理**：FIFO确保单次处理
3. **内存管理**：限制队列大小防止泄漏
4. **架构分离**：录制协程 + 处理协程

### 修复结果
- ✅ 解决重复识别问题
- ✅ 保持标点符号功能
- ✅ 优化内存使用
- ✅ 提升处理效率

### 经验教训
1. 深入分析原始实现的重要性
2. 音频处理中队列机制的必要性
3. 避免对缓冲区重复处理的陷阱
4. 反编译代码分析的价值

---

## 历史记录
- 初始实现：基础SenseVoice集成
- 第一次优化：启用标点符号、调整线程
- 第二次修复：解决重复识别问题 ⭐ 