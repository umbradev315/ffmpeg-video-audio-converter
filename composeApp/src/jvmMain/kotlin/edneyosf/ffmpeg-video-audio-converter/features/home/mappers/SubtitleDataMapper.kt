package edneyosf.ffmpeg-video-audio-converter.features.home.mappers

import edneyosf.ffmpeg-video-audio-converter.features.common.models.Subtitle
import edneyosf.ffmpeg-video-audio-converter.ffmpeg.data.SubtitleData

fun List<SubtitleData>.toSubtitleList() = map { it.toSubtitle() }

fun SubtitleData.toSubtitle() = Subtitle(
    codecName = codecName,
    codecLongName = codecLongName,
    title = title,
    language = language
)