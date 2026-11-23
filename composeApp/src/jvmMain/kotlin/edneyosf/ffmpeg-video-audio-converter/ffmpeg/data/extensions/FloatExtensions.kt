package edneyosf.ffmpeg-video-audio-converter.ffmpeg.data.extensions

fun Float.toDuration() = (this * 1000).toLong()