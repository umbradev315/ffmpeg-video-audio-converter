package edneyosf.ffmpeg-video-audio-converter.ffmpeg.data

import kotlinx.serialization.Serializable

@Serializable
data class FFprobeData(val format: FormatData, val streams: List<StreamData>)