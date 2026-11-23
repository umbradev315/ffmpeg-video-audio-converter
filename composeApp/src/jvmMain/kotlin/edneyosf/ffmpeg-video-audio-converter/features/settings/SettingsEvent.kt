package edneyosf.ffmpeg-video-audio-converter.features.settings

import edneyosf.ffmpeg-video-audio-converter.features.settings.states.SettingsStatusState

interface SettingsEvent {
    fun setStatus(status: SettingsStatusState) = Unit
    fun setFFmpegPath(path: String) = Unit
    fun setFFprobePath(path: String) = Unit
    fun onSave() = Unit
}