package com.sherpaonnxapp.speech

import android.content.res.AssetManager
import android.util.Log
import com.k2fsa.sherpa.onnx.*
import java.util.concurrent.BlockingQueue
import java.util.concurrent.LinkedBlockingQueue
import java.util.concurrent.atomic.AtomicBoolean
import kotlin.math.max

class SherpaOnnxBridge(private val assetManager: AssetManager) {
    private var offlineRecognizer: OfflineRecognizer? = null
    private var vad: Vad? = null
    private val TAG = "SherpaOnnxBridge"
    
    // 音频处理相关
    private val sampleRate = 16000
    private val windowSize = 6400 // 0.4秒窗口
    private val audioBuffer = mutableListOf<Float>()
    private val isProcessing = AtomicBoolean(false)
    private val audioQueue: BlockingQueue<FloatArray> = LinkedBlockingQueue()
    
    // 语音检测状态
    private var isSpeechStarted = false
    private var speechSegmentStart = 0
    private var resultList = mutableListOf<String>()
    
    // 实时识别状态
    private var lastStableText = ""
    private var stableCounter = 0
    private var currentPartialText = ""
    
    // 🔧 新增：Flutter风格的重复检测机制
    private var lastProcessedText = ""
    private var duplicateCounter = 0
    private val maxDuplicates = 3

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
            Log.i(TAG, "Initializing SenseVoice + VAD recognizer")
            
            // 初始化VAD
            vad = createVAD()
            
            // 初始化SenseVoice识别器
            offlineRecognizer = createSenseVoiceRecognizer()
            
            Log.i(TAG, "SenseVoice + VAD recognizer initialized successfully")
            true
        } catch (e: Exception) {
            Log.e(TAG, "Failed to initialize recognizer: ${e.message}")
            e.printStackTrace()
            false
        }
    }

    private fun createVAD(): Vad {
        // 使用直接构造函数创建VAD配置
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
        // 使用直接构造函数创建SenseVoice配置
        val senseVoiceConfig = OfflineSenseVoiceModelConfig(
            model = "models/sherpa-onnx-sense-voice-zh-en-ja-ko-yue-2024-07-17/model.int8.onnx",
            language = "",  // 空字符串表示自动检测语言
            useInverseTextNormalization = true
        )
        
        val modelConfig = OfflineModelConfig(
            senseVoice = senseVoiceConfig,
            tokens = "models/sherpa-onnx-sense-voice-zh-en-ja-ko-yue-2024-07-17/tokens.txt",
            modelType = "sense_voice",
            numThreads = 2,  // 严格复刻：强制设置为2线程
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

    fun startRecognition(): Boolean {
        return try {
            if (offlineRecognizer == null || vad == null) {
                initialize()
            }
            
            // 清空缓冲区和状态
            audioBuffer.clear()
            resultList.clear()
            isSpeechStarted = false
            speechSegmentStart = 0
            lastStableText = ""
            stableCounter = 0
            currentPartialText = ""
            
            Log.i(TAG, "Started SenseVoice recognition")
            true
        } catch (e: Exception) {
            Log.e(TAG, "Failed to start recognition: ${e.message}")
            false
        }
    }

    fun processAudio(audioData: FloatArray, sampleRate: Int): String {
        return try {
            if (isProcessing.get()) {
                return getCurrentText()
            }
            
            isProcessing.set(true)
            
            // 🔧 改进：添加音频分块处理（复刻Flutter逻辑）
            processAudioInChunks(audioData)
            
            isProcessing.set(false)
            getCurrentText()
        } catch (e: Exception) {
            Log.e(TAG, "Failed to process audio: ${e.message}")
            isProcessing.set(false)
            ""
        }
    }

    // 🔧 新增：模仿Flutter的音频分块处理
    private fun processAudioInChunks(audioData: FloatArray) {
        val chunkSize = 1600 // 0.1秒音频块，完全复刻Flutter
        
        audioBuffer.addAll(audioData.toList())
        
        // 🎯 精确的滑动窗口机制（复刻Flutter逻辑）
        if (audioBuffer.size >= windowSize * 3) {
            val newOffset = audioBuffer.size - windowSize
            val removeCount = audioBuffer.size - windowSize
            repeat(removeCount) { audioBuffer.removeAt(0) }
        }
        
        // 🎯 VAD处理 - 主要用于检测完整语音段
        if (audioBuffer.size >= chunkSize) {
            processVADWithBuffer()
        }
        
        // 🎯 优化的实时识别 - 减少频率避免跳动（复刻Flutter算法）
        if (audioBuffer.size >= windowSize && audioBuffer.size % 800 == 0) {
            performStableRealtimeRecognition()
        }
    }
    
    // 🔧 改进：复刻Flutter的VAD处理逻辑
    private fun processVADWithBuffer() {
        try {
            val vadChunkSize = 1600 // 与Flutter保持一致
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
                // 添加到结果列表
                resultList.add(text)
                Log.i(TAG, "Speech segment recognized: $text")
            }
            
            stream?.release()
        } catch (e: Exception) {
            Log.e(TAG, "Error processing speech segment: ${e.message}")
        }
    }

    private fun performRealtimeRecognition() {
        try {
            if (audioBuffer.size < windowSize) return
            
            val windowStart = max(0, audioBuffer.size - windowSize)
            val windowAudio = FloatArray(windowSize)
            
            for (i in 0 until windowSize) {
                windowAudio[i] = audioBuffer[windowStart + i]
            }
            
            val stream = offlineRecognizer?.createStream()
            stream?.acceptWaveform(windowAudio, sampleRate)
            
            offlineRecognizer?.decode(stream!!)
            val result = offlineRecognizer?.getResult(stream!!)
            val text = result?.text?.trim() ?: ""
            
            // 稳定性检查 - 减少文字跳动
            if (text.isNotEmpty() && text.length > 1) {
                if (text == lastStableText) {
                    stableCounter++
                    if (stableCounter >= 2) {
                        // 连续2次相同才更新
                        currentPartialText = text
                    }
                } else {
                    lastStableText = text
                    stableCounter = 1
                }
            }
            
            stream?.release()
        } catch (e: Exception) {
            Log.e(TAG, "Error in realtime recognition: ${e.message}")
        }
    }

    private fun getCurrentText(): String {
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
        
        return displayText.toString()
    }

    fun finishRecognition(): String {
        return try {
            // 处理剩余的音频缓冲区
            if (audioBuffer.isNotEmpty()) {
                // 🔧 修复：使用新的音频处理方法
                processAudioInChunks(FloatArray(0)) // 触发最终处理
            }
            
            val finalText = getCurrentText()
            Log.i(TAG, "Recognition finished with result: $finalText")
            finalText
        } catch (e: Exception) {
            Log.e(TAG, "Failed to finish recognition: ${e.message}")
            ""
        }
    }

    fun destroy() {
        try {
            vad?.release()
            offlineRecognizer?.release()
            vad = null
            offlineRecognizer = null
            audioBuffer.clear()
            resultList.clear()
            Log.i(TAG, "Resources destroyed")
        } catch (e: Exception) {
            Log.e(TAG, "Error during destroy: ${e.message}")
        }
    }
    
    // 🔧 新增：复刻Flutter的重复检测算法
    private fun isResultDuplicate(newResult: String): Boolean {
        if (newResult.isEmpty() || newResult.length <= 1) return true
        
        // 1. 完全相同检测
        if (newResult == lastProcessedText) {
            duplicateCounter++
            return duplicateCounter > maxDuplicates
        }
        
        // 2. 重复字符模式检测（如"服了服了服了"）
        val chars = newResult.toCharArray()
        if (chars.size > 4) {
            val firstChar = chars[0]
            val allSame = chars.all { it == firstChar || it == ' ' }
            if (allSame) {
                Log.w(TAG, "Detected repeated character pattern: $newResult")
                return true
            }
        }
        
        // 3. 词汇重复检测（>50%重复）
        val words = newResult.split("\\s+".toRegex()).filter { it.isNotEmpty() }
        if (words.size > 2) {
            val uniqueWords = words.toSet()
            if (uniqueWords.size < words.size * 0.5) {
                Log.w(TAG, "Detected word repetition pattern: $newResult")
                return true
            }
        }
        
        // 重置计数器
        lastProcessedText = newResult
        duplicateCounter = 0
        return false
    }
    
    // 🔧 改进：更稳定的实时识别
    private fun performStableRealtimeRecognition() {
        try {
            if (audioBuffer.size < windowSize) return
            
            val windowStart = max(0, audioBuffer.size - windowSize)
            val windowAudio = FloatArray(windowSize)
            
            for (i in 0 until windowSize) {
                windowAudio[i] = audioBuffer[windowStart + i]
            }
            
            val stream = offlineRecognizer?.createStream()
            stream?.acceptWaveform(windowAudio, sampleRate)
            
            offlineRecognizer?.decode(stream!!)
            val result = offlineRecognizer?.getResult(stream!!)
            val text = result?.text?.trim() ?: ""
            
            // 🎯 重复检测 + 稳定性检查
            if (text.isNotEmpty() && !isResultDuplicate(text)) {
                if (text == lastStableText) {
                    stableCounter++
                    if (stableCounter >= 2) {
                        // 连续2次相同且非重复才更新
                        updateRealtimeTextStable(text)
                    }
                } else {
                    // 上一个结果稳定后才可能添加到结果列表
                    if (stableCounter >= 2 && lastStableText.isNotEmpty()) {
                        // 这里可以考虑是否需要将稳定的结果添加到最终列表
                        Log.d(TAG, "Previous stable result: $lastStableText")
                    }
                    lastStableText = text
                    stableCounter = 1
                }
            }
            
            stream?.release()
        } catch (e: Exception) {
            Log.e(TAG, "Error in stable realtime recognition: ${e.message}")
        }
    }
    
    // 🔧 新增：稳定的实时文本更新
    private fun updateRealtimeTextStable(text: String) {
        if (text == currentPartialText) return // 避免重复更新
        
        currentPartialText = text
        Log.d(TAG, "Updated stable partial text: $text")
    }
} 