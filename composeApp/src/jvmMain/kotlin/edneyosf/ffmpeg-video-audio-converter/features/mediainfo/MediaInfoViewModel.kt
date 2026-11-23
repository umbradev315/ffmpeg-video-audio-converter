package edneyosf.ffmpeg-video-audio-converter.features.mediainfo

import androidx.lifecycle.ViewModel
import edneyosf.ffmpeg-video-audio-converter.core.process.EdProcess
import edneyosf.ffmpeg-video-audio-converter.features.common.models.InputMedia

class MediaInfoViewModel(private val process: EdProcess) : ViewModel(), MediaInfoEvent {

    override fun removeItem(item: InputMedia) = process.removeFromInputs(item)
}