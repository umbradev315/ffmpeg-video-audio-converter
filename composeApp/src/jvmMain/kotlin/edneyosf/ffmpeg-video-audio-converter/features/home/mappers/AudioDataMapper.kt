package edneyosf.ffmpeg-video-audio-converter.features.home.mappers

import edneyosf.ffmpeg-video-audio-converter.core.extensions.toReadableBitrate
import edneyosf.ffmpeg-video-audio-converter.features.common.models.Audio
import edneyosf.ffmpeg-video-audio-converter.ffmpeg.data.AudioData

fun List<AudioData>.toAudioList() = mapNotNull { data ->
    data.channels?.let {
        Audio(
            codecName = data.codecName,
            codecLongName = data.codecLongName,
            title = data.title,
            language = data.language,
            profile = data.profile,
            channels = it,
            sampleRate = data.sampleRate,
            bitDepth = data.bitDepth,
            bitRate = data.bitRate,
            bitRateText = data.bitRate?.toReadableBitrate()
        )
    }
}