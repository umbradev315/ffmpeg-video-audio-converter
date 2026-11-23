package edneyosf.ffmpeg-video-audio-converter.core.config

import kotlinx.serialization.Serializable

@Serializable
data class Config(
    var ffmpegPath: String = "",
    var ffprobePath: String = "",
    var vmafModelPath: String = ""
)