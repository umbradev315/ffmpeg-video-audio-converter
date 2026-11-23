package edneyosf.ffmpeg-video-audio-converter.features.home.ui

import androidx.compose.runtime.Composable
import edneyosf.ffmpeg-video-audio-converter.features.home.HomeEvent
import edneyosf.ffmpeg-video-audio-converter.features.home.states.HomeDialogState
import edneyosf.ffmpeg-video-audio-converter.features.home.states.HomeState
import edneyosf.ffmpeg-video-audio-converter.features.settings.ui.SettingsDialog

@Composable
fun HomeState.Dialogs(event: HomeEvent) = dialog.run {
    when(this) {
        is HomeDialogState.Failure -> {
            HomeErrorDialog(
                error = error,
                onFinish = { event.setDialog(HomeDialogState.None) }
            )
        }
        is HomeDialogState.Settings -> SettingsDialog { event.setDialog(HomeDialogState.None) }
        else -> Unit
    }
}