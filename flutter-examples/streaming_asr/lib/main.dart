// Copyright (c)  2024  Xiaomi Corporation
import 'package:flutter/material.dart';
import './simulate_streaming_asr.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'SenseVoice 多语言语音识别',
      theme: ThemeData(
        primarySwatch: Colors.blue,
        visualDensity: VisualDensity.adaptivePlatformDensity,
      ),
      home: const SimulateStreamingAsrScreen(),
      debugShowCheckedModeBanner: false,
    );
  }
}
