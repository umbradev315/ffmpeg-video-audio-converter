package edneyosf.ffmpeg-video-audio-converter.features.home.mappers

import edneyosf.ffmpeg-video-audio-converter.core.extensions.toDurationString
import edneyosf.ffmpeg-video-audio-converter.core.extensions.toReadableBitrate
import edneyosf.ffmpeg-video-audio-converter.core.extensions.toReadableSize
import edneyosf.ffmpeg-video-audio-converter.features.common.models.InputMedia
import edneyosf.ffmpeg-video-audio-converter.ffmpeg.data.InputMediaData
import java.util.UUID

@Throws(IllegalStateException::class)
fun InputMediaData.toInputMedia(): InputMedia {
    val safeDuration = requireNotNull(value = duration) {
        "Cannot map InputMediaData to InputMedia: duration must not be null"
    }

    return InputMedia(
        id = UUID.randomUUID().toString(),
        path = path,
        type = type,
        size = size,
        sizeText = size.toReadableSize(),
        formatName = formatName,
        duration = safeDuration,
        durationText = safeDuration.toDurationString(),
        bitRate = bitRate,
        bitRateText = bitRate?.toReadableBitrate(),
        videos = videoStreams.toVideoList(),
        audios = audioStreams.toAudioList(),
        subtitles = subtitleStreams.toSubtitleList()
    )
}