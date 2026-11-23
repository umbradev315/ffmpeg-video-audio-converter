package edneyosf.ffmpeg-video-audio-converter.ffmpeg.data.mappers

import edneyosf.ffmpeg-video-audio-converter.ffmpeg.data.AudioData
import edneyosf.ffmpeg-video-audio-converter.ffmpeg.data.StreamData
import edneyosf.ffmpeg-video-audio-converter.ffmpeg.data.SubtitleData
import edneyosf.ffmpeg-video-audio-converter.ffmpeg.data.VideoData
import edneyosf.ffmpeg-video-audio-converter.ffmpeg.data.extensions.toFrameRate

fun StreamData.toVideoStream() = VideoData(
    codecName = codecName,
    codecLongName = codecLongName,
    title = tags?.title,
    language = tags?.language,
    profile = profile,
    width = width,
    height = height,
    bitDepth = bitDepth,
    pixFmt = pixFmt,
    fps = frameRate?.toFrameRate(),
    level = level,
    filmGrain = filmGrain == 1,
    displayAspectRatio = displayAspectRatio,
    fieldOrder = fieldOrder,
    bitRate = bitRate ?: tags?.bps
)

fun StreamData.toAudioStream() = AudioData(
    codecName = codecName,
    codecLongName = codecLongName,
    title = tags?.title,
    language = tags?.language,
    profile = profile,
    channels = channels,
    sampleRate = sampleRate,
    bitDepth = bitDepth,
    bitRate = bitRate ?: tags?.bps
)

fun StreamData.toSubtitleStream() = SubtitleData(
    codecName = codecName,
    codecLongName = codecLongName,
    title = tags?.title,
    language = tags?.language
)