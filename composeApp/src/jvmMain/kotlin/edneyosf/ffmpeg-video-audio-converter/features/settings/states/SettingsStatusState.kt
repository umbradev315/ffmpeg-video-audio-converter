package edneyosf.ffmpeg-video-audio-converter.features.settings.states

import edneyosf.ffmpeg-video-audio-converter.core.common.Error

sealed interface SettingsStatusState {
    data object Initial: SettingsStatusState
    data object Loading: SettingsStatusState
    data object Complete: SettingsStatusState
    data class Failure(val error: Error): SettingsStatusState
}