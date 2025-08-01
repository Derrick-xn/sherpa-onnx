// Copyright 2024 Xiaomi Corporation

package com.k2fsa.sherpa.onnx;

public class OfflineModelConfig {
    private final OfflineTransducerModelConfig transducer;
    private final OfflineParaformerModelConfig paraformer;
    private final OfflineWhisperModelConfig whisper;
    private final OfflineFireRedAsrModelConfig fireRedAsr;
    private final OfflineMoonshineModelConfig moonshine;
    private final OfflineNemoEncDecCtcModelConfig nemo;
    private final OfflineSenseVoiceModelConfig senseVoice;
    private final OfflineDolphinModelConfig dolphin;
    private final OfflineZipformerCtcModelConfig zipformerCtc;
    private final String teleSpeech;
    private final String tokens;
    private final int numThreads;
    private final boolean debug;
    private final String provider;

    private final String modelType;
    private final String modelingUnit;
    private final String bpeVocab;

    private OfflineModelConfig(Builder builder) {
        this.transducer = builder.transducer;
        this.paraformer = builder.paraformer;
        this.whisper = builder.whisper;
        this.fireRedAsr = builder.fireRedAsr;
        this.moonshine = builder.moonshine;
        this.nemo = builder.nemo;
        this.zipformerCtc = builder.zipformerCtc;
        this.senseVoice = builder.senseVoice;
        this.dolphin = builder.dolphin;
        this.teleSpeech = builder.teleSpeech;
        this.tokens = builder.tokens;
        this.numThreads = builder.numThreads;
        this.debug = builder.debug;
        this.provider = builder.provider;
        this.modelType = builder.modelType;
        this.modelingUnit = builder.modelingUnit;
        this.bpeVocab = builder.bpeVocab;
    }

    public static Builder builder() {
        return new Builder();
    }

    public OfflineParaformerModelConfig getParaformer() {
        return paraformer;
    }

    public OfflineTransducerModelConfig getTransducer() {
        return transducer;
    }

    public OfflineWhisperModelConfig getWhisper() {
        return whisper;
    }

    public OfflineMoonshineModelConfig getMoonshine() {
        return moonshine;
    }

    public OfflineSenseVoiceModelConfig getSenseVoice() {
        return senseVoice;
    }

    public OfflineDolphinModelConfig getDolphin() {
        return dolphin;
    }

    public OfflineNemoEncDecCtcModelConfig getNemo() {
        return nemo;
    }

    public OfflineZipformerCtcModelConfig getZipformerCtc() {
        return zipformerCtc;
    }

    public String getTokens() {
        return tokens;
    }

    public int getNumThreads() {
        return numThreads;
    }

    public boolean getDebug() {
        return debug;
    }

    public String getProvider() {
        return provider;
    }

    public String getModelType() {
        return modelType;
    }

    public String getModelingUnit() {
        return modelingUnit;
    }

    public String getBpeVocab() {
        return bpeVocab;
    }

    public String getTeleSpeech() {
        return teleSpeech;
    }

    public static class Builder {
        private OfflineParaformerModelConfig paraformer = OfflineParaformerModelConfig.builder().build();
        private OfflineTransducerModelConfig transducer = OfflineTransducerModelConfig.builder().build();
        private OfflineWhisperModelConfig whisper = OfflineWhisperModelConfig.builder().build();
        private OfflineFireRedAsrModelConfig fireRedAsr = OfflineFireRedAsrModelConfig.builder().build();
        private OfflineMoonshineModelConfig moonshine = OfflineMoonshineModelConfig.builder().build();
        private OfflineNemoEncDecCtcModelConfig nemo = OfflineNemoEncDecCtcModelConfig.builder().build();
        private OfflineSenseVoiceModelConfig senseVoice = OfflineSenseVoiceModelConfig.builder().build();
        private OfflineDolphinModelConfig dolphin = OfflineDolphinModelConfig.builder().build();
        private OfflineZipformerCtcModelConfig zipformerCtc = OfflineZipformerCtcModelConfig.builder().build();
        private String teleSpeech = "";
        private String tokens = "";
        private int numThreads = 1;
        private boolean debug = true;
        private String provider = "cpu";
        private String modelType = "";
        private String modelingUnit = "cjkchar";
        private String bpeVocab = "";

        public OfflineModelConfig build() {
            return new OfflineModelConfig(this);
        }

        public Builder setTransducer(OfflineTransducerModelConfig transducer) {
            this.transducer = transducer;
            return this;
        }

        public Builder setDolphin(OfflineDolphinModelConfig dolphin) {
            this.dolphin = dolphin;
            return this;
        }

        public Builder setParaformer(OfflineParaformerModelConfig paraformer) {
            this.paraformer = paraformer;
            return this;
        }

        public Builder setNemo(OfflineNemoEncDecCtcModelConfig nemo) {
            this.nemo = nemo;
            return this;
        }

        public Builder setZipformerCtc(OfflineZipformerCtcModelConfig zipformerCtc) {
            this.zipformerCtc = zipformerCtc;
            return this;
        }

        public Builder setTeleSpeech(String teleSpeech) {
            this.teleSpeech = teleSpeech;
            return this;
        }

        public Builder setWhisper(OfflineWhisperModelConfig whisper) {
            this.whisper = whisper;
            return this;
        }

        public Builder setFireRedAsr(OfflineFireRedAsrModelConfig fireRedAsr) {
            this.fireRedAsr = fireRedAsr;
            return this;
        }

        public Builder setSenseVoice(OfflineSenseVoiceModelConfig senseVoice) {
            this.senseVoice = senseVoice;
            return this;
        }

        public Builder setMoonshine(OfflineMoonshineModelConfig moonshine) {
            this.moonshine = moonshine;
            return this;
        }

        public Builder setTokens(String tokens) {
            this.tokens = tokens;
            return this;
        }

        public Builder setNumThreads(int numThreads) {
            this.numThreads = numThreads;
            return this;
        }

        public Builder setDebug(boolean debug) {
            this.debug = debug;
            return this;
        }

        public Builder setProvider(String provider) {
            this.provider = provider;
            return this;
        }

        public Builder setModelType(String modelType) {
            this.modelType = modelType;
            return this;
        }

        public Builder setModelingUnit(String modelingUnit) {
            this.modelingUnit = modelingUnit;
            return this;
        }

        public Builder setBpeVocab(String bpeVocab) {
            this.bpeVocab = bpeVocab;
            return this;
        }
    }
}