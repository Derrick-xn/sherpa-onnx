/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 *
 * @format
 */

import React, {useState, useEffect} from 'react';
import {
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

const { SherpaOnnxModule } = NativeModules;

function App(): React.JSX.Element {
  const [isRecording, setIsRecording] = useState(false);
  const [recognizedText, setRecognizedText] = useState('');
  const [status, setStatus] = useState('准备就绪');
  const [recordTime, setRecordTime] = useState('00:00:00');
  const [recordingInterval, setRecordingInterval] = useState<NodeJS.Timeout | null>(null);
  const [isInitialized, setIsInitialized] = useState(false);

  useEffect(() => {
    // 🚀 初始化新的双协程架构
    initializeDualCoroutineRecognizer();

    // 🎯 监听流式识别结果（反编译APK风格）
    const resultSubscription = DeviceEventEmitter.addListener('onRecognitionResult', (event) => {
      console.log('📱 Real-time result update:', event.text);
      setRecognizedText(event.text);
    });

    // 监听状态变化
    const startSubscription = DeviceEventEmitter.addListener('onRecognitionStarted', () => {
      console.log('🎙️ Recognition started');
    });

    const stopSubscription = DeviceEventEmitter.addListener('onRecognitionStopped', () => {
      console.log('🛑 Recognition stopped');
    });

    const finishSubscription = DeviceEventEmitter.addListener('onRecognitionFinished', () => {
      console.log('✅ Recognition finished');
    });

    return () => {
      resultSubscription?.remove();
      startSubscription?.remove();
      stopSubscription?.remove();
      finishSubscription?.remove();
    };
  }, []);

  // 🚀 初始化双协程架构识别器
  const initializeDualCoroutineRecognizer = async () => {
    try {
      setStatus('正在初始化双协程架构...');
      console.log('🚀 Initializing dual-coroutine SenseVoice recognizer');
      
      const initialized = await SherpaOnnxModule.initialize();
      if (initialized) {
        setIsInitialized(true);
        setStatus('✅ 双协程架构就绪');
        console.log('✅ Dual-coroutine architecture initialized successfully');
      } else {
        setStatus('❌ 初始化失败');
        console.error('❌ Failed to initialize dual-coroutine architecture');
      }
    } catch (error) {
      console.error('❌ Initialization error:', error);
      setStatus('❌ 初始化错误');
      Alert.alert('初始化失败', '无法初始化语音识别系统');
    }
  };

  // 获取录音权限
  const requestAudioPermission = async (): Promise<boolean> => {
    if (Platform.OS !== 'android') {
      return true;
    }

    try {
      const granted = await PermissionsAndroid.request(
        PermissionsAndroid.PERMISSIONS.RECORD_AUDIO,
        {
          title: '录音权限',
          message: '需要录音权限来进行语音识别',
          buttonNeutral: '稍后询问',
          buttonNegative: '取消',
          buttonPositive: '确定',
        },
      );
      
      return granted === PermissionsAndroid.RESULTS.GRANTED;
    } catch (err) {
      console.error('权限请求失败:', err);
      return false;
    }
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

  // 🎙️ 开始录音和语音识别（双协程架构）
  const startRecording = async () => {
    if (!isInitialized) {
      Alert.alert('系统错误', '双协程架构尚未初始化完成');
      return;
    }

    const hasPermission = await requestAudioPermission();
    if (!hasPermission) {
      Alert.alert('权限错误', '需要录音权限才能使用语音识别功能');
      return;
    }

    try {
      setIsRecording(true);
      setStatus('🎙️ 录音中...');
      setRecordTime('00:00:00');
      startRecordingTimer();
      
      // 🚀 启动双协程录音（AnonymousClass1 + AnonymousClass2）
      await SherpaOnnxModule.startRecognition();
      console.log('🎙️ Dual-coroutine recognition started successfully');
      
    } catch (error) {
      console.error('❌ 启动录音失败:', error);
      setIsRecording(false);
      setStatus('❌ 录音失败');
      stopRecordingTimer();
      Alert.alert('错误', '录音启动失败，请重试');
    }
  };

  // 🛑 停止录音和语音识别
  const stopRecording = async () => {
    try {
      setStatus('🔄 处理中...');
      stopRecordingTimer();
      
      // 🛑 停止双协程录音
      await SherpaOnnxModule.stopRecognition();
      console.log('🛑 Dual-coroutine recognition stopped');
      
      setIsRecording(false);
      setStatus('✅ 准备就绪');
      setRecordTime('00:00:00');
      
    } catch (error) {
      console.error('❌ 停止录音失败:', error);
      setIsRecording(false);
      setStatus('❌ 停止失败');
      Alert.alert('错误', '停止录音失败');
    }
  };

  // 清空文本
  const clearText = () => {
    setRecognizedText('');
  };

  return (
    <ScrollView style={styles.container}>
      <StatusBar barStyle="dark-content" backgroundColor="#ffffff" />
      
      {/* 标题区域 - 反编译APK风格 */}
      <View style={styles.headerContainer}>
        <Text style={styles.titleText}>SenseVoice 语音识别</Text>
        <Text style={styles.subtitleText}>基于 Sherpa-ONNX + VAD</Text>
        <View style={styles.statusBadge}>
          <Text style={styles.statusBadgeText}>
            {isInitialized ? '✅ 双协程就绪' : '🔄 初始化中...'}
          </Text>
        </View>
        {isInitialized && (
          <Text style={styles.configText}>
            🚀 AnonymousClass1: 录音协程 | 🔄 AnonymousClass2: 处理协程
          </Text>
        )}
        <Text style={styles.architectureText}>
          📱 原生AudioRecord + Channel通信 + 流式更新
        </Text>
      </View>

      {/* 状态指示区域 */}
      <View style={styles.statusContainer}>
        <Text style={styles.statusText}>{status}</Text>
        {isRecording && (
          <Text style={styles.recordTime}>{recordTime}</Text>
        )}
      </View>

      {/* 识别结果显示区域 - 流式更新 */}
      <View style={styles.textContainer}>
        <ScrollView style={styles.resultScrollView}>
          <Text style={styles.recognizedText}>
            {recognizedText || (isInitialized ? 
              '🎙️ 点击开始录音，体验双协程流式识别...\n\n✨ 特性：\n• 原生AudioRecord录音\n• 双协程并行处理\n• Channel通信机制\n• 实时流式更新\n• VAD语音分段\n• 多语言识别（中英日韩粤）' : 
              '🔄 正在初始化双协程架构，请稍候...'
            )}
          </Text>
        </ScrollView>
      </View>

      {/* 控制按钮 - 反编译APK风格 */}
      <View style={styles.controlsContainer}>
        <TouchableOpacity
          style={[
            styles.recordButton,
            isRecording ? styles.recordingButton : 
            isInitialized ? styles.idleButton : styles.disabledButton
          ]}
          onPress={isRecording ? stopRecording : startRecording}
          disabled={!isInitialized}
        >
          <Text style={styles.recordButtonText}>
            {isRecording ? '🛑 停止录音' : '🎙️ 开始录音'}
          </Text>
        </TouchableOpacity>

        <TouchableOpacity
          style={styles.clearButton}
          onPress={clearText}
        >
          <Text style={styles.clearButtonText}>🗑️ 清空文本</Text>
        </TouchableOpacity>
      </View>

      {/* 底部信息 */}
      <View style={styles.footerContainer}>
        <Text style={styles.footerText}>
          🚀 SenseVoice 双协程架构 {isInitialized ? '已就绪' : '准备中'}
        </Text>
        <Text style={styles.architectureInfo}>
          复刻反编译APK的流式处理机制
        </Text>
      </View>
    </ScrollView>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#f5f5f5',
  },
  headerContainer: {
    alignItems: 'center',
    paddingVertical: 20,
    backgroundColor: '#ffffff',
    elevation: 2,
    shadowColor: '#000',
    shadowOffset: {width: 0, height: 2},
    shadowOpacity: 0.1,
    shadowRadius: 4,
  },
  titleText: {
    fontSize: 24,
    fontWeight: 'bold',
    color: '#333333',
  },
  subtitleText: {
    fontSize: 14,
    color: '#666666',
    marginTop: 4,
  },
  statusBadge: {
    backgroundColor: '#E3F2FD',
    borderRadius: 12,
    paddingVertical: 6,
    paddingHorizontal: 12,
    marginTop: 8,
    borderWidth: 1,
    borderColor: '#2196F3',
  },
  statusBadgeText: {
    fontSize: 12,
    color: '#1976D2',
    fontWeight: 'bold',
  },
  configText: {
    fontSize: 11,
    color: '#666666',
    marginTop: 8,
    textAlign: 'center',
  },
  architectureText: {
    fontSize: 10,
    color: '#9E9E9E',
    marginTop: 4,
    textAlign: 'center',
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
  resultScrollView: {
    flex: 1,
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
    padding: 16,
    alignItems: 'center',
    backgroundColor: '#ffffff',
  },
  footerText: {
    fontSize: 12,
    color: '#999999',
    fontStyle: 'italic',
  },
  architectureInfo: {
    fontSize: 10,
    color: '#BDBDBD',
    marginTop: 4,
    textAlign: 'center',
  },
});

export default App;
