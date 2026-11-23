package edneyosf.ffmpeg-video-audio-converter.ffmpeg.data

import kotlinx.serialization.Serializable

@Serializable
data class SubtitleData(
    val codecName: String? = null,
    val codecLongName: String? = null,
    val title: String? = null,
    val language: String? = null
)