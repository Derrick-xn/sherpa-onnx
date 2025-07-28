package com.sherpaonnxapp.audio

import android.Manifest
import android.content.pm.PackageManager
import android.media.AudioFormat
import android.media.AudioRecord
import android.media.MediaRecorder
import android.util.Log
import androidx.core.app.ActivityCompat
import com.facebook.react.bridge.*
import com.facebook.react.modules.core.DeviceEventManagerModule
import kotlin.concurrent.thread

class AudioRecorderModule(reactContext: ReactApplicationContext) : ReactContextBaseJavaModule(reactContext) {

    private var audioRecord: AudioRecord? = null
    private var isRecording = false
    private var recordingThread: Thread? = null
    private val TAG = "AudioRecorderModule"
    
    // 音频参数
    private val sampleRateInHz = 16000
    private val channelConfig = AudioFormat.CHANNEL_IN_MONO
    private val audioFormat = AudioFormat.ENCODING_PCM_16BIT
    private val audioSource = MediaRecorder.AudioSource.VOICE_RECOGNITION

    override fun getName(): String {
        return "AudioRecorderModule"
    }

    @ReactMethod
    fun checkPermission(promise: Promise) {
        val hasPermission = ActivityCompat.checkSelfPermission(
            reactApplicationContext, 
            Manifest.permission.RECORD_AUDIO
        ) == PackageManager.PERMISSION_GRANTED
        
        promise.resolve(hasPermission)
    }

    @ReactMethod
    fun startRecording(promise: Promise) {
        try {
            if (isRecording) {
                promise.reject("ALREADY_RECORDING", "Recording is already in progress")
                return
            }

            // 检查录音权限
            if (ActivityCompat.checkSelfPermission(
                    reactApplicationContext,
                    Manifest.permission.RECORD_AUDIO
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                promise.reject("PERMISSION_DENIED", "Audio recording permission not granted")
                return
            }

            // 计算缓冲区大小
            val bufferSize = AudioRecord.getMinBufferSize(sampleRateInHz, channelConfig, audioFormat)
            
            // 创建AudioRecord实例
            audioRecord = AudioRecord(
                audioSource,
                sampleRateInHz,
                channelConfig,
                audioFormat,
                bufferSize * 2
            )

            if (audioRecord?.state != AudioRecord.STATE_INITIALIZED) {
                promise.reject("INIT_ERROR", "Failed to initialize AudioRecord")
                return
            }

            // 开始录音
            audioRecord?.startRecording()
            isRecording = true

            Log.i(TAG, "Recording started")

            // 创建录音线程
            recordingThread = thread(true) {
                processAudioData()
            }

            promise.resolve("Recording started")

        } catch (e: Exception) {
            Log.e(TAG, "Error starting recording: ${e.message}")
            promise.reject("START_ERROR", e.message)
        }
    }

    @ReactMethod
    fun stopRecording(promise: Promise) {
        try {
            isRecording = false
            
            audioRecord?.stop()
            audioRecord?.release()
            audioRecord = null
            
            recordingThread?.join(1000) // 等待线程结束
            recordingThread = null

            Log.i(TAG, "Recording stopped")
            promise.resolve("Recording stopped")

        } catch (e: Exception) {
            Log.e(TAG, "Error stopping recording: ${e.message}")
            promise.reject("STOP_ERROR", e.message)
        }
    }

    private fun processAudioData() {
        Log.i(TAG, "Audio processing thread started")
        
        val bufferSize = 1024 // 64ms at 16kHz
        val buffer = ShortArray(bufferSize)

        while (isRecording && audioRecord != null) {
            val samplesRead = audioRecord?.read(buffer, 0, buffer.size) ?: 0
            
            if (samplesRead > 0) {
                // 转换为Float32Array
                val floatArray = FloatArray(samplesRead) { buffer[it] / 32768.0f }
                
                // 发送音频数据到React Native
                sendAudioData(floatArray)
            }
        }
        
        Log.i(TAG, "Audio processing thread ended")
    }

    private fun sendAudioData(audioData: FloatArray) {
        try {
            val params = Arguments.createMap()
            val audioArray = Arguments.createArray()
            
            for (sample in audioData) {
                audioArray.pushDouble(sample.toDouble())
            }
            
            params.putArray("audioData", audioArray)
            params.putInt("sampleRate", sampleRateInHz)
            
            reactApplicationContext
                .getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter::class.java)
                .emit("onAudioData", params)
                
        } catch (e: Exception) {
            Log.e(TAG, "Error sending audio data: ${e.message}")
        }
    }

    override fun onCatalystInstanceDestroy() {
        super.onCatalystInstanceDestroy()
        if (isRecording) {
            isRecording = false
            audioRecord?.stop()
            audioRecord?.release()
            audioRecord = null
        }
    }
} 