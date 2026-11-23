package edneyosf.ffmpeg-video-audio-converter.features.metrics

import edneyosf.ffmpeg-video-audio-converter.features.metrics.states.MetricsStatusState

interface MetricsEvent {
    fun setStatus(status: MetricsStatusState) = Unit
    fun pickDistortedFile(title: String) = Unit
    fun setFps(value: String) = Unit
    fun setThread(value: String) = Unit
    fun start() = Unit
    fun stop() = Unit
    fun setVmaf(enabled: Boolean) = Unit
    fun setPsnr(enabled: Boolean) = Unit
    fun setSsim(enabled: Boolean) = Unit
}