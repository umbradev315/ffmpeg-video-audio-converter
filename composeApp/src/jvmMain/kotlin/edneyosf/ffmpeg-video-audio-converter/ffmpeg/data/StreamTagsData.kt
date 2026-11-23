package edneyosf.ffmpeg-video-audio-converter.ffmpeg.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class StreamTagsData(
    val title: String? = null,
    val language: String? = null,
    @SerialName(value = "BPS")
    val bps: Long? = null
)