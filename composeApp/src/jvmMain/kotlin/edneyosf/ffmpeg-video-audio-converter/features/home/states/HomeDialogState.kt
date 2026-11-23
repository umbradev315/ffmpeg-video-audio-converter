package edneyosf.ffmpeg-video-audio-converter.features.home.states

import edneyosf.ffmpeg-video-audio-converter.core.common.Error

sealed interface HomeDialogState {
    data object None: HomeDialogState
    data class Failure(val error: Error): HomeDialogState
    data object Settings: HomeDialogState
}