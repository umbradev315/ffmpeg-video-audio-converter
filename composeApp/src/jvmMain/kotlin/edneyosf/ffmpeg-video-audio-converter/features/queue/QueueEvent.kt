package edneyosf.ffmpeg-video-audio-converter.features.queue

import edneyosf.ffmpeg-video-audio-converter.core.process.MediaQueue

interface QueueEvent {
    fun removeItem(item: MediaQueue) = Unit
    fun clear() = Unit

    fun setShutdown(value: Boolean) = Unit
}