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
            Log.i(TAG, "SherpaOnnxModule initialized")
        } catch (e: Exception) {
            Log.e(TAG, "Failed to initialize SherpaOnnxModule: ${e.message}")
        }
    }

    @ReactMethod
    fun initialize(promise: Promise) {
        try {
            val success = bridge?.initialize() ?: false
            if (success) {
                promise.resolve(true)
                Log.i(TAG, "Recognizer initialized successfully")
            } else {
                promise.reject("INIT_ERROR", "Failed to initialize recognizer")
            }
        } catch (e: Exception) {
            Log.e(TAG, "Error initializing recognizer: ${e.message}")
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
            } else {
                promise.reject("START_ERROR", "Failed to start recognition")
            }
        } catch (e: Exception) {
            Log.e(TAG, "Error starting recognition: ${e.message}")
            promise.reject("START_ERROR", e.message)
        }
    }

    @ReactMethod
    fun processAudio(audioData: ReadableArray, sampleRate: Int, promise: Promise) {
        try {
            Log.d(TAG, "=== processAudio called ===")
            Log.d(TAG, "Audio data size: ${audioData.size()}")
            Log.d(TAG, "Sample rate: $sampleRate")
            
            val floatArray = FloatArray(audioData.size())
            for (i in 0 until audioData.size()) {
                floatArray[i] = audioData.getDouble(i).toFloat()
            }
            
            Log.d(TAG, "Converted to float array, length: ${floatArray.size}")
            if (floatArray.isNotEmpty()) {
                Log.d(TAG, "Sample values (first 5): ${floatArray.take(5)}")
            }
            
            val result = bridge?.processAudio(floatArray, sampleRate) ?: ""
            Log.d(TAG, "Bridge returned result: '$result'")
            
            promise.resolve(result)
            
            if (result.isNotEmpty()) {
                Log.d(TAG, "Sending recognition result event")
                val params = Arguments.createMap()
                params.putString("text", result)
                sendEvent("onRecognitionResult", params)
            } else {
                Log.d(TAG, "Result is empty, not sending event")
            }
        } catch (e: Exception) {
            Log.e(TAG, "Error processing audio: ${e.message}")
            e.printStackTrace()
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
            Log.e(TAG, "Error finishing recognition: ${e.message}")
            promise.reject("FINISH_ERROR", e.message)
        }
    }

    @ReactMethod
    fun destroy(promise: Promise) {
        try {
            bridge?.destroy()
            promise.resolve(true)
        } catch (e: Exception) {
            Log.e(TAG, "Error destroying recognizer: ${e.message}")
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