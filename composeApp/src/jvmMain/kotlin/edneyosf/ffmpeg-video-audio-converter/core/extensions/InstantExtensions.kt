package edneyosf.ffmpeg-video-audio-converter.core.extensions

import edneyosf.ffmpeg-video-audio-converter.core.common.DateTimePattern
import edneyosf.ffmpeg-video-audio-converter.core.utils.DateTimeUtils
import java.time.Instant

fun Instant.formatTime() = DateTimeUtils.instantToText(instant = this, pattern = DateTimePattern.TIME_HMS)

fun Instant.durationUntil(end: Instant) = DateTimeUtils.durationText(this, end)