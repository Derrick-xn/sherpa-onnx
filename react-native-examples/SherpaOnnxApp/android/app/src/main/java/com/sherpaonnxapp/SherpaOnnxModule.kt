package com.sherpaonnxapp

import android.content.res.AssetManager
import android.util.Log
import com.facebook.react.bridge.*
import com.facebook.react.modules.core.DeviceEventManagerModule
import com.sherpaonnxapp.speech.SherpaOnnxBridge

class SherpaOnnxModule(reactContext: ReactApplicationContext) : ReactContextBaseJavaModule(reactContext) {
    
    private var bridge: SherpaOnnxBridge? = null
    private val TAG = "SherpaOnnxModule"

    override fun getName(): String {
        return "SherpaOnnxModule"
    }

    init {
        try {
            val assetManager: AssetManager = reactContext.assets
            bridge = SherpaOnnxBridge(assetManager)
            
            // 🚀 设置回调，实现反编译APK式的流畅更新
            bridge?.setResultCallback { resultText ->
                val params = Arguments.createMap()
                params.putString("text", resultText)
                sendEvent("onRecognitionResult", params)
            }
            
            // 🚀 立即开始后台初始化，不等待JS层调用
            Thread {
                try {
                    val success = bridge?.initialize() ?: false
                    if (success) {
                        Log.i(TAG, "✅ 后台预初始化成功")
                        val params = Arguments.createMap()
                        params.putBoolean("success", true)
                        sendEvent("onInitialized", params)
                    } else {
                        Log.e(TAG, "❌ 后台预初始化失败")
                    }
                } catch (e: Exception) {
                    Log.e(TAG, "❌ 后台预初始化错误: ${e.message}")
                }
            }.start()
            
            Log.i(TAG, "🎯 SherpaOnnxModule initialized with APK-style architecture")
        } catch (e: Exception) {
            Log.e(TAG, "❌ Failed to initialize SherpaOnnxModule: ${e.message}")
        }
    }

    @ReactMethod
    fun initialize(promise: Promise) {
        try {
            // 如果已经初始化成功，直接返回true
            if (bridge?.isInitialized() == true) {
                promise.resolve(true)
                Log.i(TAG, "✅ Recognizer already initialized")
                return
            }
            
            val success = bridge?.initialize() ?: false
            if (success) {
                promise.resolve(true)
                Log.i(TAG, "✅ Recognizer initialized successfully")
            } else {
                promise.reject("INIT_ERROR", "Failed to initialize recognizer")
            }
        } catch (e: Exception) {
            Log.e(TAG, "❌ Error initializing recognizer: ${e.message}")
            promise.reject("INIT_ERROR", e.message)
        }
    }

    @ReactMethod
    fun startRecognition(promise: Promise) {
        try {
            val success = bridge?.startRecognition() ?: false
            if (success) {
                promise.resolve(true)
                sendEvent("onRecognitionStarted", null)
                Log.i(TAG, "🎙️ Dual-coroutine recognition started")
            } else {
                promise.reject("START_ERROR", "Failed to start recognition")
            }
        } catch (e: Exception) {
            Log.e(TAG, "❌ Error starting recognition: ${e.message}")
            promise.reject("START_ERROR", e.message)
        }
    }

    @ReactMethod
    fun stopRecognition(promise: Promise) {
        try {
            val success = bridge?.stopRecognition() ?: false
            if (success) {
                // 🎵 获取录音文件路径
                val recordingPath = bridge?.getLastRecordingPath()
                
                val result = Arguments.createMap()
                result.putBoolean("success", true)
                if (recordingPath != null) {
                    result.putString("recordingPath", recordingPath)
                    Log.i(TAG, "🎵 Recording saved to: $recordingPath")
                }
                
                promise.resolve(result)
                sendEvent("onRecognitionStopped", null)
                
                // 🎵 发送录音文件路径事件
                if (recordingPath != null) {
                    val params = Arguments.createMap()
                    params.putString("filePath", recordingPath)
                    sendEvent("onRecordingFileSaved", params)
                }
                
                Log.i(TAG, "🛑 Recognition stopped successfully")
            } else {
                promise.reject("STOP_ERROR", "Failed to stop recognition")
            }
        } catch (e: Exception) {
            Log.e(TAG, "❌ Error stopping recognition: ${e.message}")
            promise.reject("STOP_ERROR", e.message)
        }
    }

    // 🎵 获取最后录音文件路径
    @ReactMethod
    fun getLastRecordingPath(promise: Promise) {
        try {
            val recordingPath = bridge?.getLastRecordingPath()
            if (recordingPath != null) {
                promise.resolve(recordingPath)
            } else {
                promise.resolve(null)
            }
        } catch (e: Exception) {
            Log.e(TAG, "❌ Error getting recording path: ${e.message}")
            promise.reject("GET_PATH_ERROR", e.message)
        }
    }

    // 🎯 保留兼容性：由于现在使用原生AudioRecord，这个方法主要用于获取当前状态
    @ReactMethod
    fun processAudio(audioData: ReadableArray, sampleRate: Int, promise: Promise) {
        try {
            // 现在主要通过原生AudioRecord处理，这里返回当前结果即可
            val result = bridge?.processAudio(FloatArray(0), sampleRate) ?: ""
            promise.resolve(result)
        } catch (e: Exception) {
            Log.e(TAG, "❌ Error in processAudio: ${e.message}")
            promise.reject("PROCESS_ERROR", e.message)
        }
    }

    @ReactMethod
    fun finishRecognition(promise: Promise) {
        try {
            val result = bridge?.finishRecognition() ?: ""
            
            // 🎵 获取录音文件路径
            val recordingPath = bridge?.getLastRecordingPath()
            
            val responseMap = Arguments.createMap()
            responseMap.putString("text", result)
            if (recordingPath != null) {
                responseMap.putString("recordingPath", recordingPath)
            }
            
            promise.resolve(responseMap)
            sendEvent("onRecognitionFinished", null)
            
            if (result.isNotEmpty()) {
                val params = Arguments.createMap()
                params.putString("text", result)
                sendEvent("onRecognitionResult", params)
            }
            
            // 🎵 发送录音文件路径事件
            if (recordingPath != null) {
                val params = Arguments.createMap()
                params.putString("filePath", recordingPath)
                sendEvent("onRecordingFileSaved", params)
            }
        } catch (e: Exception) {
            Log.e(TAG, "❌ Error finishing recognition: ${e.message}")
            promise.reject("FINISH_ERROR", e.message)
        }
    }

    @ReactMethod
    fun destroy(promise: Promise) {
        try {
            bridge?.destroy()
            promise.resolve(true)
        } catch (e: Exception) {
            Log.e(TAG, "❌ Error destroying recognizer: ${e.message}")
            promise.reject("DESTROY_ERROR", e.message)
        }
    }

    private fun sendEvent(eventName: String, params: WritableMap?) {
        reactApplicationContext
            .getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter::class.java)
            .emit(eventName, params)
    }

    override fun onCatalystInstanceDestroy() {
        super.onCatalystInstanceDestroy()
        bridge?.destroy()
    }
} 