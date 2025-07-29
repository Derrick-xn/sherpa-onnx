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
            
            Log.i(TAG, "🎯 SherpaOnnxModule initialized with APK-style architecture")
        } catch (e: Exception) {
            Log.e(TAG, "❌ Failed to initialize SherpaOnnxModule: ${e.message}")
        }
    }

    @ReactMethod
    fun initialize(promise: Promise) {
        try {
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
                promise.resolve(true)
                sendEvent("onRecognitionStopped", null)
                Log.i(TAG, "🛑 Recognition stopped successfully")
            } else {
                promise.reject("STOP_ERROR", "Failed to stop recognition")
            }
        } catch (e: Exception) {
            Log.e(TAG, "❌ Error stopping recognition: ${e.message}")
            promise.reject("STOP_ERROR", e.message)
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
            promise.resolve(result)
            sendEvent("onRecognitionFinished", null)
            
            if (result.isNotEmpty()) {
                val params = Arguments.createMap()
                params.putString("text", result)
                sendEvent("onRecognitionResult", params)
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