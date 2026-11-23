package edneyosf.ffmpeg-video-audio-converter.features.metrics.ui

import androidx.compose.runtime.Composable
import edneyosf.ffmpeg-video-audio-converter.core.config.RemoteConfig
import edneyosf.ffmpeg-video-audio-converter.features.metrics.MetricsEvent
import edneyosf.ffmpeg-video-audio-converter.features.metrics.states.MetricsState
import edneyosf.ffmpeg-video-audio-converter.features.metrics.states.MetricsStatusState.*
import org.koin.compose.koinInject

@Composable
fun MetricsState.Dialogs(event: MetricsEvent) {
    val remoteConfig = koinInject<RemoteConfig>()
    val donationUrl = remoteConfig.donationUrl

    status.run {
        when (this) {
            is Failure -> {
                MetricsErrorDialog(
                    error = error,
                    onFinish = { event.setStatus(Initial) }
                )
            }
            is Complete -> {
                MetricsCompleteDialog(
                    vmafScore = vmafScore,
                    psnrScore = psnrScore,
                    ssimScore = ssimScore,
                    startTime = startTime,
                    finishTime = finishTime,
                    duration = duration,
                    donationUrl = donationUrl,
                    onFinish = { event.setStatus(Initial) }
                )
            }
            else -> Unit
        }
    }
}