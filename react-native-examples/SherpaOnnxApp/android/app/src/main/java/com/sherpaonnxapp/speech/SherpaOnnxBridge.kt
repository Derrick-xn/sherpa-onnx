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

// 🚀 完全复刻反编译APK的双协程架构
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
    
    // 🎯 结果管理
    private val resultList = mutableListOf<String>()
    private var currentPartialText = ""
    private var onResultCallback: ((String) -> Unit)? = null

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

    // 🎯 复刻反编译APK的双协程启动
    fun startRecognition(): Boolean {
        return try {
            if (offlineRecognizer == null || vad == null || audioRecord == null) {
                initialize()
            }
            
            // 重置状态（复刻反编译APK）
            audioBuffer.clear()
            resultList.clear()
            lastText = ""
            offset = 0
            isSpeechStarted = false
            startTime = System.currentTimeMillis()
            added = false
            currentPartialText = ""
            
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
            
            // 🎯 优化的实时识别 - 减少频率避免跳动（复刻APK算法）
            if (audioBuffer.size >= windowSize && audioBuffer.size % 800 == 0) {
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
            
            if (text.isNotEmpty() && text.length > 1) {
                // 🎯 添加到结果列表（复刻反编译APK）
                resultList.add(text)
                updateResults()
                Log.i(TAG, "✅ Speech segment recognized: $text")
            }
            
            stream?.release()
        } catch (e: Exception) {
            Log.e(TAG, "Error processing speech segment: ${e.message}")
        }
    }

    private fun performStableRealtimeRecognition() {
        try {
            if (audioBuffer.size < windowSize) return
            
            val windowStart = kotlin.math.max(0, audioBuffer.size - windowSize)
            val windowAudio = FloatArray(windowSize)
            
            for (i in 0 until windowSize) {
                windowAudio[i] = audioBuffer[windowStart + i]
            }
            
            val stream = offlineRecognizer?.createStream()
            stream?.acceptWaveform(windowAudio, sampleRate)
            
            offlineRecognizer?.decode(stream!!)
            val result = offlineRecognizer?.getResult(stream!!)
            val text = result?.text?.trim() ?: ""
            
            // 🎯 稳定性检查 - 减少文字跳动
            if (text.isNotEmpty() && text.length > 1 && text != lastText) {
                lastText = text
                currentPartialText = text
                updateResults()
            }
            
            stream?.release()
        } catch (e: Exception) {
            Log.e(TAG, "Error in realtime recognition: ${e.message}")
        }
    }

    // 🎯 更新结果显示（复刻反编译APK格式）
    private fun updateResults() {
        val displayText = StringBuilder()
        
        // 添加已完成的识别结果
        resultList.forEachIndexed { index, text ->
            displayText.append("${index + 1}: $text")
            if (index < resultList.size - 1) {
                displayText.append("\n")
            }
        }
        
        // 添加当前部分识别结果
        if (currentPartialText.isNotEmpty()) {
            if (displayText.isNotEmpty()) {
                displayText.append("\n")
            }
            displayText.append("${resultList.size + 1}: $currentPartialText")
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
        
        if (currentPartialText.isNotEmpty()) {
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