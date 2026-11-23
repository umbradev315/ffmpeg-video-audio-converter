package edneyosf.ffmpeg-video-audio-converter.features.settings.states

data class SettingsState(
    val status: SettingsStatusState = SettingsStatusState.Initial,
    val ffmpegPath: String = "",
    val ffprobePath: String = "",
)