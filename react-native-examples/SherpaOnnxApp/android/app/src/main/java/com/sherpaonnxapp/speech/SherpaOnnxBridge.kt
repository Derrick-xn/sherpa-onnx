package com.sherpaonnxapp.speech

import android.content.res.AssetManager
import android.util.Log
import android.media.AudioRecord
import android.media.MediaRecorder
import android.media.AudioFormat
import com.k2fsa.sherpa.onnx.*
import java.util.concurrent.atomic.AtomicBoolean
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.Channel.Factory.UNLIMITED
import java.io.File
import java.io.FileOutputStream
import java.io.RandomAccessFile
import java.text.SimpleDateFormat
import java.util.*

// 🚀 完全复刻反编译APK的双协程架构 + 录音文件保存
class SherpaOnnxBridge(private val assetManager: AssetManager) {
    private var offlineRecognizer: OfflineRecognizer? = null
    private var vad: Vad? = null
    private val TAG = "SherpaOnnxBridge"
    
    // 🎯 反编译APK的核心参数
    private val sampleRate = 16000
    private val windowSize = 6400 // 0.4秒窗口（完全复刻）
    private val chunkSize = 1600   // 0.1秒音频块（完全复刻）
    
    // 🎯 双协程通信Channel（复刻反编译APK）
    private val samplesChannel = Channel<FloatArray>(UNLIMITED)
    
    // 🎯 反编译APK的状态变量（完全对应）
    private val audioBuffer = mutableListOf<Float>()
    private var lastText = ""
    private var offset = 0
    private var isSpeechStarted = false
    private var startTime = 0L
    private var added = false
    
    // 🎯 原生AudioRecord（复刻反编译APK）
    private var audioRecord: AudioRecord? = null
    private val isRecording = AtomicBoolean(false)
    private var recordingJob: Job? = null
    private var processingJob: Job? = null
    
    // 🎯 结果管理 - 优化显示逻辑
    private val resultList = mutableListOf<String>()
    private var currentPartialText = ""
    private var lastStableText = ""
    private var stableCounter = 0
    private var silentCounter = 0        // 🔧 新增：静音计数器
    private val maxSilentFrames = 10     // 🔧 新增：最大静音帧数
    private var onResultCallback: ((String) -> Unit)? = null
    
    // 🎵 录音文件保存功能
    private var audioFileWriter: FileOutputStream? = null
    private var currentAudioFile: File? = null
    private var recordedAudioData = mutableListOf<Short>()

    companion object {
        init {
            try {
                System.loadLibrary("sherpa-onnx-jni")
                Log.i("SherpaOnnxBridge", "Successfully loaded sherpa-onnx-jni library")
            } catch (e: UnsatisfiedLinkError) {
                Log.e("SherpaOnnxBridge", "Failed to load sherpa-onnx-jni library: ${e.message}")
            }
        }
    }

    fun initialize(): Boolean {
        return try {
            Log.i(TAG, "🚀 Initializing SenseVoice + VAD recognizer (APK-style)")
            
            // 初始化原生AudioRecord（复刻反编译APK）
            initializeAudioRecord()
            
            // 初始化VAD
            vad = createVAD()
            
            // 初始化SenseVoice识别器
            offlineRecognizer = createSenseVoiceRecognizer()
            
            Log.i(TAG, "✅ SenseVoice + VAD recognizer initialized successfully")
            true
        } catch (e: Exception) {
            Log.e(TAG, "❌ Failed to initialize recognizer: ${e.message}")
            e.printStackTrace()
            false
        }
    }

    // 🎯 复刻反编译APK的AudioRecord初始化
    private fun initializeAudioRecord() {
        val channelConfig = AudioFormat.CHANNEL_IN_MONO
        val audioFormat = AudioFormat.ENCODING_PCM_16BIT
        val minBufferSize = AudioRecord.getMinBufferSize(sampleRate, channelConfig, audioFormat)
        val bufferSize = minBufferSize.coerceAtLeast(chunkSize * 2)
        
        audioRecord = AudioRecord(
            MediaRecorder.AudioSource.MIC,
            sampleRate,
            channelConfig,
            audioFormat,
            bufferSize
        )
        
        Log.i(TAG, "🎙️ AudioRecord initialized: bufferSize=$bufferSize, chunkSize=$chunkSize")
    }

    private fun createVAD(): Vad {
        val sileroVadConfig = SileroVadModelConfig(
            model = "silero_vad.onnx",
            threshold = 0.45f,
            minSilenceDuration = 0.5f,
            minSpeechDuration = 0.25f,
            maxSpeechDuration = 8.0f,
            windowSize = 512
        )
        
        val vadConfig = VadModelConfig(
            sileroVadModelConfig = sileroVadConfig,
            sampleRate = sampleRate,
            numThreads = 1,
            provider = "cpu",
            debug = false
        )
        
        return Vad(assetManager, vadConfig)
    }

    private fun createSenseVoiceRecognizer(): OfflineRecognizer {
        val senseVoiceConfig = OfflineSenseVoiceModelConfig(
            model = "models/sherpa-onnx-sense-voice-zh-en-ja-ko-yue-2024-07-17/model.int8.onnx",
            language = "",  // 空字符串表示自动检测语言
            useInverseTextNormalization = true
        )
        
        val modelConfig = OfflineModelConfig(
            senseVoice = senseVoiceConfig,
            tokens = "models/sherpa-onnx-sense-voice-zh-en-ja-ko-yue-2024-07-17/tokens.txt",
            modelType = "sense_voice",
            numThreads = 2,  // 🎯 严格复刻：强制设置为2线程
            debug = false,
            provider = "cpu"
        )
        
        val recognizerConfig = OfflineRecognizerConfig(
            featConfig = getFeatureConfig(sampleRate = sampleRate, featureDim = 80),
            modelConfig = modelConfig,
            decodingMethod = "greedy_search",
            maxActivePaths = 4
        )
        
        return OfflineRecognizer(assetManager, recognizerConfig)
    }

    // 🎵 初始化录音文件
    private fun initializeAudioFile(): File? {
        return try {
            val timestamp = SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(Date())
            val fileName = "recording_$timestamp.wav"
            
            // 使用外部存储的 Downloads 目录
            val downloadsDir = File("/storage/emulated/0/Download")
            if (!downloadsDir.exists()) {
                downloadsDir.mkdirs()
            }
            
            val audioFile = File(downloadsDir, fileName)
            
            // 创建 WAV 文件头（44字节）
            val fileOutputStream = FileOutputStream(audioFile)
            writeWavHeader(fileOutputStream, 0) // 先写一个占位的header
            
            audioFileWriter = fileOutputStream
            currentAudioFile = audioFile
            recordedAudioData.clear()
            
            Log.i(TAG, "🎵 Audio file initialized: ${audioFile.absolutePath}")
            audioFile
        } catch (e: Exception) {
            Log.e(TAG, "❌ Failed to initialize audio file: ${e.message}")
            null
        }
    }

    // 🎵 写入WAV文件头
    private fun writeWavHeader(fos: FileOutputStream, dataSize: Int) {
        val header = ByteArray(44)
        val fileSize = dataSize + 36
        
        // RIFF header
        "RIFF".toByteArray().copyInto(header, 0)
        intToByteArray(fileSize).copyInto(header, 4)
        "WAVE".toByteArray().copyInto(header, 8)
        
        // fmt chunk
        "fmt ".toByteArray().copyInto(header, 12)
        intToByteArray(16).copyInto(header, 16)  // fmt chunk size
        shortToByteArray(1).copyInto(header, 20) // PCM format
        shortToByteArray(1).copyInto(header, 22) // channels
        intToByteArray(sampleRate).copyInto(header, 24) // sample rate
        intToByteArray(sampleRate * 2).copyInto(header, 28) // byte rate
        shortToByteArray(2).copyInto(header, 32) // block align
        shortToByteArray(16).copyInto(header, 34) // bits per sample
        
        // data chunk
        "data".toByteArray().copyInto(header, 36)
        intToByteArray(dataSize).copyInto(header, 40)
        
        fos.write(header)
    }

    private fun intToByteArray(value: Int): ByteArray {
        return byteArrayOf(
            (value and 0xFF).toByte(),
            ((value shr 8) and 0xFF).toByte(),
            ((value shr 16) and 0xFF).toByte(),
            ((value shr 24) and 0xFF).toByte()
        )
    }

    private fun shortToByteArray(value: Int): ByteArray {
        return byteArrayOf(
            (value and 0xFF).toByte(),
            ((value shr 8) and 0xFF).toByte()
        )
    }

    // 🎯 复刻反编译APK的双协程启动
    fun startRecognition(): Boolean {
        return try {
            if (offlineRecognizer == null || vad == null || audioRecord == null) {
                initialize()
            }
            
            // 🔧 彻底重置所有状态，确保干净开始
            audioBuffer.clear()
            resultList.clear()
            lastText = ""
            lastStableText = ""
            stableCounter = 0
            silentCounter = 0           // 🔧 重置静音计数器
            offset = 0
            isSpeechStarted = false
            startTime = System.currentTimeMillis()
            added = false
            currentPartialText = ""
            
            // 🔧 立即发送空结果，清空UI显示
            onResultCallback?.invoke("")
            
            // 🎵 初始化录音文件
            initializeAudioFile()
            
            isRecording.set(true)
            
            // 🚀 启动双协程（完全复刻反编译APK架构）
            startAnonymousClass1() // 音频录制协程
            startAnonymousClass2() // 音频处理协程
            
            Log.i(TAG, "🎙️ sherpa-onnx-sim-asr: Started dual-coroutine recording")
            true
        } catch (e: Exception) {
            Log.e(TAG, "❌ Failed to start recognition: ${e.message}")
            false
        }
    }

    // 🎯 AnonymousClass1: 音频录制协程（完全复刻反编译APK）
    private fun startAnonymousClass1() {
        recordingJob = CoroutineScope(Dispatchers.IO).launch {
            Log.i(TAG, "🎙️ sherpa-onnx-sim-asr: processing samples")
            
            // 完全复刻反编译APK：16000 * 0.1 = 1600样本
            val bufferSize = (sampleRate * 0.1).toInt()
            val shortBuffer = ShortArray(bufferSize)
            
            audioRecord?.startRecording()
            
            while (isRecording.get()) {
                val bytesRead = audioRecord?.read(shortBuffer, 0, shortBuffer.size) ?: -1
                
                if (bytesRead > 0) {
                    // 🎵 保存录音数据
                    recordedAudioData.addAll(shortBuffer.take(bytesRead))
                    
                    // 🎯 完全复刻反编译APK的转换逻辑
                    val floatSamples = FloatArray(bytesRead)
                    for (i in 0 until bytesRead) {
                        val shortSample = shortBuffer[i]
                        floatSamples[i] = shortSample.toFloat() / 32768.0f // 复刻APK转换
                    }
                    
                    // 通过Channel发送（复刻反编译APK）
                    samplesChannel.trySend(floatSamples)
                }
            }
            
            // 发送空数组结束信号（复刻反编译APK）
            samplesChannel.trySend(FloatArray(0))
        }
    }

    // 🎯 AnonymousClass2: 音频处理协程（完全复刻反编译APK）
    private fun startAnonymousClass2() {
        processingJob = CoroutineScope(Dispatchers.Default).launch {
            Log.i(TAG, "🔄 sherpa-onnx-sim-asr: 启动AnonymousClass2")
            
            // 复刻反编译APK的循环处理
            for (samples in samplesChannel) {
                if (samples.isEmpty()) break // 结束信号
                
                // 🎯 完全复刻反编译APK的处理逻辑
                processAnonymousClass2Logic(samples)
            }
        }
    }

    // 🎯 核心：AnonymousClass2的处理逻辑（完全复刻反编译APK）
    private suspend fun processAnonymousClass2Logic(floatSamples: FloatArray) {
        try {
            audioBuffer.addAll(floatSamples.toList())
            
            // 🔧 更严格的音频信号检测
            val audioEnergy = floatSamples.sumOf { kotlin.math.abs(it.toDouble()) } / floatSamples.size
            val hasSignificantAudio = audioEnergy > 0.005 // 提高阈值
            
            if (!hasSignificantAudio) {
                silentCounter++
                // 🔧 静音时立即清除实时文本，避免虚假识别
                if (silentCounter > 3 && currentPartialText.isNotEmpty()) {
                    currentPartialText = ""
                    updateResults()
                    Log.d(TAG, "🔇 Cleared partial text due to silence")
                }
                // 🔧 长时间静音时不进行实时识别
                if (silentCounter > maxSilentFrames) {
                    return
                }
            } else {
                silentCounter = 0
                isSpeechStarted = true // 标记开始有语音输入
            }
            
            // 🎯 VAD处理 - 主要用于检测完整语音段
            if (audioBuffer.size >= chunkSize) {
                processVADWithBuffer()
            }
            
            // 🎯 滑动窗口机制（复刻反编译APK逻辑）
            if (audioBuffer.size >= windowSize * 3) {
                val removeCount = audioBuffer.size - windowSize
                repeat(removeCount) { audioBuffer.removeAt(0) }
                offset += removeCount
            }
            
            // 🔧 只在确实有语音输入且音频能量足够时才进行实时识别
            if (hasSignificantAudio && isSpeechStarted && audioBuffer.size >= windowSize && audioBuffer.size % 800 == 0) {
                performStableRealtimeRecognition()
            }
        } catch (e: Exception) {
            Log.e(TAG, "AnonymousClass2处理错误: ${e.message}")
        }
    }

    private fun processVADWithBuffer() {
        try {
            val vadChunkSize = chunkSize
            if (audioBuffer.size >= vadChunkSize) {
                val vadData = FloatArray(vadChunkSize)
                val startIndex = kotlin.math.max(0, audioBuffer.size - vadChunkSize)
                
                for (i in 0 until vadChunkSize) {
                    vadData[i] = audioBuffer[startIndex + i]
                }
                
                vad?.acceptWaveform(vadData)
                
                // 🎯 处理VAD检测到的完整语音段
                while (vad?.empty() == false) {
                    val speechSegment = vad?.front()
                    vad?.pop()
                    
                    if (speechSegment != null) {
                        processFinalSpeechSegment(speechSegment)
                    }
                }
            }
        } catch (e: Exception) {
            Log.e(TAG, "VAD processing error: ${e.message}")
        }
    }

    private fun processFinalSpeechSegment(speechSegment: SpeechSegment) {
        try {
            val stream = offlineRecognizer?.createStream()
            stream?.acceptWaveform(speechSegment.samples, sampleRate)
            
            offlineRecognizer?.decode(stream!!)
            val result = offlineRecognizer?.getResult(stream!!)
            val text = result?.text?.trim() ?: ""
            
            // 🔧 只添加有意义的文本（长度>2，且不是单个字符重复）
            if (text.isNotEmpty() && text.length > 2 && !isRepeatedCharacter(text)) {
                resultList.add(text)
                currentPartialText = "" // 清除实时文本
                updateResults()
                Log.i(TAG, "✅ Speech segment recognized: $text")
            }
            
            stream?.release()
        } catch (e: Exception) {
            Log.e(TAG, "Error processing speech segment: ${e.message}")
        }
    }

    // 🔧 检测是否为重复字符
    private fun isRepeatedCharacter(text: String): Boolean {
        if (text.length < 3) return false
        val firstChar = text[0]
        return text.all { it == firstChar || it == '。' || it == '，' }
    }

    private fun performStableRealtimeRecognition() {
        try {
            if (audioBuffer.size < windowSize) return
            
            val windowStart = kotlin.math.max(0, audioBuffer.size - windowSize)
            val windowAudio = FloatArray(windowSize)
            
            for (i in 0 until windowSize) {
                windowAudio[i] = audioBuffer[windowStart + i]
            }
            
            // 🔧 检查音频窗口的音频能量，避免处理静音段
            val windowEnergy = windowAudio.sumOf { kotlin.math.abs(it.toDouble()) } / windowAudio.size
            if (windowEnergy < 0.003) {
                return // 跳过低能量音频段
            }
            
            val stream = offlineRecognizer?.createStream()
            stream?.acceptWaveform(windowAudio, sampleRate)
            
            offlineRecognizer?.decode(stream!!)
            val result = offlineRecognizer?.getResult(stream!!)
            val text = result?.text?.trim() ?: ""
            
            // 🔧 更严格的文本过滤：避免单词、重复字符、过短文本
            if (isValidRecognitionText(text) && text != lastText) {
                // 取消稳定性要求，立即显示有效识别结果
                lastText = text
                currentPartialText = text
                updateResults()
                Log.d(TAG, "🔊 立即显示识别结果: $text")
            }
            
            stream?.release()
        } catch (e: Exception) {
            Log.e(TAG, "Error in realtime recognition: ${e.message}")
        }
    }
    
    // 🔧 更严格的文本验证
    private fun isValidRecognitionText(text: String): Boolean {
        if (text.isEmpty() || text.length < 3) return false
        if (isRepeatedCharacter(text)) return false
        
        // 过滤常见的虚假识别结果
        val invalidTexts = listOf("yeah", "uh", "um", "ah", "oh", "er", "呃", "嗯", "啊", "哦")
        if (invalidTexts.any { text.lowercase().contains(it) && text.length <= 6 }) {
            return false
        }
        
        // 确保包含有意义的字符（中文、英文单词等）
        val hasMeaningfulContent = text.any { it.isLetter() || it in '\u4e00'..'\u9fff' }
        return hasMeaningfulContent
    }

    // 🎯 更新结果显示（复刻反编译APK格式）
    private fun updateResults() {
        val displayText = StringBuilder()
        
        // 添加已完成的识别结果
        resultList.forEachIndexed { index, text ->
            displayText.append("$text")
//            if (index < resultList.size - 1) {
  //              displayText.append("\n")
    //        }
        }
        
        // 🔧 只在有有效识别结果时添加当前部分识别结果
        if (currentPartialText.isNotEmpty() && isValidRecognitionText(currentPartialText)) {
        //    if (displayText.isNotEmpty()) {
         //       displayText.append("\n")
        //    }
            displayText.append("$currentPartialText")
        }
        
        // 回调更新UI（模拟反编译APK的自动滚动效果）
        onResultCallback?.invoke(displayText.toString())
    }

    fun setResultCallback(callback: (String) -> Unit) {
        onResultCallback = callback
    }

    fun stopRecognition(): Boolean {
        return try {
            isRecording.set(false)
            
            // 停止录音
            audioRecord?.stop()
            
            // 🎵 完成录音文件写入
            finalizeAudioFile()
            
            // 取消协程
            recordingJob?.cancel()
            processingJob?.cancel()
            
            Log.i(TAG, "🛑 Recognition stopped")
            true
        } catch (e: Exception) {
            Log.e(TAG, "❌ Failed to stop recognition: ${e.message}")
            false
        }
    }

    // 🎵 完成音频文件写入
    private fun finalizeAudioFile() {
        try {
            if (audioFileWriter != null && currentAudioFile != null && recordedAudioData.isNotEmpty()) {
                // 写入音频数据
                for (sample in recordedAudioData) {
                    audioFileWriter!!.write(sample.toInt() and 0xFF)
                    audioFileWriter!!.write((sample.toInt() shr 8) and 0xFF)
                }
                
                audioFileWriter!!.close()
                
                // 更新WAV文件头
                val dataSize = recordedAudioData.size * 2
                val randomAccessFile = RandomAccessFile(currentAudioFile!!, "rw")
                
                // 更新文件大小
                randomAccessFile.seek(4)
                randomAccessFile.write(intToByteArray(dataSize + 36))
                
                // 更新数据大小
                randomAccessFile.seek(40)
                randomAccessFile.write(intToByteArray(dataSize))
                
                randomAccessFile.close()
                
                Log.i(TAG, "🎵 Audio file saved: ${currentAudioFile!!.absolutePath}")
                Log.i(TAG, "🎵 File size: ${currentAudioFile!!.length()} bytes")
            }
        } catch (e: Exception) {
            Log.e(TAG, "❌ Failed to finalize audio file: ${e.message}")
        } finally {
            audioFileWriter = null
            currentAudioFile = null
            recordedAudioData.clear()
        }
    }

    // 🎵 获取最后录音文件路径
    fun getLastRecordingPath(): String? {
        return currentAudioFile?.absolutePath
    }

    fun destroy() {
        try {
            stopRecognition()
            
            audioRecord?.release()
            vad?.release()
            offlineRecognizer?.release()
            
            audioRecord = null
            vad = null
            offlineRecognizer = null
            
            audioBuffer.clear()
            resultList.clear()
            
            Log.i(TAG, "🗑️ Resources destroyed")
        } catch (e: Exception) {
            Log.e(TAG, "Error during destroy: ${e.message}")
        }
    }

    // 🎯 兼容原有接口
    fun processAudio(audioData: FloatArray, sampleRate: Int): String {
        // 由于现在使用原生AudioRecord，这个方法主要用于获取当前结果
        return getCurrentText()
    }

    private fun getCurrentText(): String {
        val displayText = StringBuilder()
        
        resultList.forEachIndexed { index, text ->
            displayText.append("${index + 1}: $text")
            if (index < resultList.size - 1) {
                displayText.append("\n")
            }
        }
        
        // 🔧 只在有有效识别结果时显示当前部分文本
        if (currentPartialText.isNotEmpty() && isValidRecognitionText(currentPartialText)) {
            if (displayText.isNotEmpty()) {
                displayText.append("\n")
            }
            displayText.append("${resultList.size + 1}: $currentPartialText")
        }
        
        return displayText.toString()
    }

    fun finishRecognition(): String {
        return try {
            stopRecognition()
            val finalText = getCurrentText()
            Log.i(TAG, "Recognition finished with result: $finalText")
            finalText
        } catch (e: Exception) {
            Log.e(TAG, "Failed to finish recognition: ${e.message}")
            ""
        }
    }
} 