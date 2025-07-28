/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 *
 * @format
 */

import React, {useState, useEffect} from 'react';
import {
  SafeAreaView,
  ScrollView,
  StatusBar,
  StyleSheet,
  Text,
  View,
  TouchableOpacity,
  Alert,
  PermissionsAndroid,
  Platform,
  NativeModules,
  DeviceEventEmitter,
} from 'react-native';

const { SherpaOnnxModule, AudioRecorderModule } = NativeModules;

function App(): React.JSX.Element {
  const [isRecording, setIsRecording] = useState(false);
  const [recognizedText, setRecognizedText] = useState('');
  const [status, setStatus] = useState('准备就绪');
  const [recordTime, setRecordTime] = useState('00:00:00');
  const [recordingInterval, setRecordingInterval] = useState<NodeJS.Timeout | null>(null);
  const [isInitialized, setIsInitialized] = useState(false);

  useEffect(() => {
    // 初始化Sherpa-ONNX
    initializeSherpaOnnx();

    // 监听音频数据
    const audioDataSubscription = DeviceEventEmitter.addListener('onAudioData', (event) => {
      console.log('Audio data received:', event.audioData ? event.audioData.length : 'null');
      if (event.audioData && event.audioData.length > 0) {
        processAudioData(event.audioData, event.sampleRate);
      }
    });

    // 监听语音识别结果
    const resultSubscription = DeviceEventEmitter.addListener('onRecognitionResult', (event) => {
      console.log('Recognition result event:', event.text);
      setRecognizedText(event.text);
    });

    return () => {
      if (recordingInterval) {
        clearInterval(recordingInterval);
      }
      audioDataSubscription.remove();
      resultSubscription.remove();
    };
  }, [recordingInterval]);

  const initializeSherpaOnnx = async () => {
    try {
      setStatus('正在初始化语音识别...');
      await SherpaOnnxModule.initialize();
      setIsInitialized(true);
      setStatus('准备就绪');
      console.log('Sherpa-ONNX initialized successfully');
    } catch (error) {
      console.error('Failed to initialize Sherpa-ONNX:', error);
      setStatus('初始化失败');
      Alert.alert('初始化错误', '语音识别初始化失败，请重试');
    }
  };

  // 请求录音权限
  const requestAudioPermission = async () => {
    if (Platform.OS === 'android') {
      try {
        const granted = await PermissionsAndroid.request(
          PermissionsAndroid.PERMISSIONS.RECORD_AUDIO,
          {
            title: '录音权限',
            message: '应用需要录音权限来进行语音识别',
            buttonNeutral: '稍后询问',
            buttonNegative: '取消',
            buttonPositive: '确定',
          },
        );
        return granted === PermissionsAndroid.RESULTS.GRANTED;
      } catch (err) {
        console.warn(err);
        return false;
      }
    }
    return true;
  };

  // 录音计时器
  const startRecordingTimer = () => {
    let seconds = 0;
    const interval = setInterval(() => {
      seconds++;
      const hours = Math.floor(seconds / 3600);
      const minutes = Math.floor((seconds % 3600) / 60);
      const secs = seconds % 60;
      
      const timeString = `${hours.toString().padStart(2, '0')}:${minutes.toString().padStart(2, '0')}:${secs.toString().padStart(2, '0')}`;
      setRecordTime(timeString);
    }, 1000);
    
    setRecordingInterval(interval);
  };

  const stopRecordingTimer = () => {
    if (recordingInterval) {
      clearInterval(recordingInterval);
      setRecordingInterval(null);
    }
  };

  // 处理音频数据
  const processAudioData = async (audioData: number[], sampleRate: number) => {
    try {
      console.log('=== processAudioData called ===');
      console.log('Audio data length:', audioData.length);
      console.log('Sample rate:', sampleRate);
      console.log('Sample values (first 10):', audioData.slice(0, 10));

      if (audioData.length > 0) {
        console.log('Calling SherpaOnnxModule.processAudio...');
        const result = await SherpaOnnxModule.processAudio(audioData, sampleRate);
        console.log('Recognition result:', result);
        
        if (result && result.trim().length > 0) {
          console.log('Setting recognized text:', result);
          setRecognizedText(prev => {
            const timestamp = new Date().toLocaleTimeString();
            const newText = `[${timestamp}] ${result}`;
            return prev ? `${prev}\n\n${newText}` : newText;
          });
        } else {
          console.log('Result is empty or null');
        }
      }
    } catch (error) {
      console.error('音频处理失败:', error);
    }
  };

  // 开始录音和语音识别
  const startRecording = async () => {
    if (!isInitialized) {
      Alert.alert('系统错误', '语音识别尚未初始化完成');
      return;
    }

    const hasPermission = await requestAudioPermission();
    if (!hasPermission) {
      Alert.alert('权限错误', '需要录音权限才能使用语音识别功能');
      return;
    }

    try {
      setIsRecording(true);
      setStatus('正在录音...');
      setRecordTime('00:00:00');
      startRecordingTimer();
      
      // 启动Sherpa-ONNX识别
      await SherpaOnnxModule.startRecognition();
      console.log('SherpaOnnx recognition started');
      
      // 开始录音
      await AudioRecorderModule.startRecording();
      console.log('AudioRecorder started');
      
    } catch (error) {
      console.error('录音启动失败:', error);
      setIsRecording(false);
      setStatus('录音失败');
      Alert.alert('错误', '录音启动失败，请重试');
    }
  };

  // 停止录音和语音识别
  const stopRecording = async () => {
    try {
      setStatus('处理中...');
      stopRecordingTimer();
      
      // 停止录音
      await AudioRecorderModule.stopRecording();
      console.log('Recording stopped');
      
      setIsRecording(false);
      setStatus('准备就绪');
      setRecordTime('00:00:00');
      
    } catch (error) {
      console.error('停止录音失败:', error);
      setIsRecording(false);
      setStatus('停止录音失败');
      Alert.alert('错误', '停止录音失败');
    }
  };

  // 清空文本
  const clearText = () => {
    setRecognizedText('');
    setStatus('准备就绪');
  };

  return (
    <SafeAreaView style={styles.container}>
      <StatusBar barStyle="dark-content" backgroundColor="#ffffff" />
      
      {/* 标题 */}
      <View style={styles.header}>
        <Text style={styles.title}>SenseVoice 语音识别</Text>
        <Text style={styles.subtitle}>基于 Sherpa-ONNX + VAD</Text>
        {!isInitialized && (
          <Text style={styles.initStatus}>正在初始化...</Text>
        )}
      </View>

      {/* 状态显示 */}
      <View style={styles.statusContainer}>
        <Text style={styles.statusText}>{status}</Text>
        {isRecording && (
          <Text style={styles.recordTime}>录音时长: {recordTime}</Text>
        )}
      </View>

      {/* 文本显示区域 */}
      <ScrollView style={styles.textContainer}>
        <Text style={styles.recognizedText}>
          {recognizedText || '点击录音按钮开始语音识别...\n\n支持中文、英文、日文、韩文、粤语等多语言识别\n集成VAD语音活动检测，自动分段识别'}
        </Text>
      </ScrollView>

      {/* 控制按钮 */}
      <View style={styles.controlsContainer}>
        <TouchableOpacity
          style={[
            styles.recordButton,
            isRecording ? styles.recordingButton : styles.idleButton,
            !isInitialized && styles.disabledButton,
          ]}
          onPress={isRecording ? stopRecording : startRecording}
          disabled={!isInitialized || status === '处理中...'}>
          <Text style={styles.recordButtonText}>
            {isRecording ? '停止录音' : '开始录音'}
          </Text>
        </TouchableOpacity>

        <TouchableOpacity
          style={[styles.clearButton, !recognizedText && styles.disabledButton]}
          onPress={clearText}
          disabled={!recognizedText || isRecording}>
          <Text style={styles.clearButtonText}>清空文本</Text>
        </TouchableOpacity>
      </View>

      {/* 说明文字 */}
      <View style={styles.footerContainer}>
        <Text style={styles.footerText}>
          {isInitialized ? 'SenseVoice 多语言语音识别已就绪' : '正在加载语音识别模型...'}
        </Text>
      </View>
    </SafeAreaView>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#f5f5f5',
  },
  header: {
    alignItems: 'center',
    paddingVertical: 20,
    backgroundColor: '#ffffff',
    elevation: 2,
    shadowColor: '#000',
    shadowOffset: {width: 0, height: 2},
    shadowOpacity: 0.1,
    shadowRadius: 4,
  },
  title: {
    fontSize: 24,
    fontWeight: 'bold',
    color: '#333333',
  },
  subtitle: {
    fontSize: 14,
    color: '#666666',
    marginTop: 4,
  },
  initStatus: {
    fontSize: 12,
    color: '#FF9800',
    marginTop: 4,
    fontStyle: 'italic',
  },
  statusContainer: {
    padding: 16,
    alignItems: 'center',
  },
  statusText: {
    fontSize: 16,
    color: '#2196F3',
    fontWeight: '500',
  },
  recordTime: {
    fontSize: 14,
    color: '#FF5722',
    marginTop: 4,
    fontFamily: 'monospace',
  },
  textContainer: {
    flex: 1,
    margin: 16,
    padding: 16,
    backgroundColor: '#ffffff',
    borderRadius: 8,
    elevation: 1,
    shadowColor: '#000',
    shadowOffset: {width: 0, height: 1},
    shadowOpacity: 0.1,
    shadowRadius: 2,
  },
  recognizedText: {
    fontSize: 16,
    lineHeight: 24,
    color: '#333333',
    minHeight: 100,
  },
  controlsContainer: {
    flexDirection: 'row',
    justifyContent: 'space-around',
    padding: 20,
    backgroundColor: '#ffffff',
  },
  recordButton: {
    flex: 1,
    paddingVertical: 16,
    paddingHorizontal: 24,
    borderRadius: 25,
    alignItems: 'center',
    marginRight: 10,
  },
  idleButton: {
    backgroundColor: '#4CAF50',
  },
  recordingButton: {
    backgroundColor: '#F44336',
  },
  disabledButton: {
    backgroundColor: '#CCCCCC',
  },
  recordButtonText: {
    color: '#ffffff',
    fontSize: 16,
    fontWeight: 'bold',
  },
  clearButton: {
    flex: 1,
    paddingVertical: 16,
    paddingHorizontal: 24,
    borderRadius: 25,
    alignItems: 'center',
    backgroundColor: '#FF9800',
    marginLeft: 10,
  },
  clearButtonText: {
    color: '#ffffff',
    fontSize: 16,
    fontWeight: 'bold',
  },
  footerContainer: {
    padding: 10,
    alignItems: 'center',
    backgroundColor: '#ffffff',
  },
  footerText: {
    fontSize: 12,
    color: '#999999',
    fontStyle: 'italic',
  },
});

export default App;
