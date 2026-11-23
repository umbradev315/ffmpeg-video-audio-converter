package edneyosf.ffmpeg-video-audio-converter.features.mediainfo

import edneyosf.ffmpeg-video-audio-converter.features.common.models.InputMedia

interface MediaInfoEvent {
    fun removeItem(item: InputMedia) = Unit
}