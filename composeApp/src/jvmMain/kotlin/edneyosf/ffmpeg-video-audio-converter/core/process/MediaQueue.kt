package edneyosf.ffmpeg-video-audio-converter.core.process

import edneyosf.ffmpeg-video-audio-converter.core.common.Error
import edneyosf.ffmpeg-video-audio-converter.features.common.models.InputMedia
import edneyosf.ffmpeg-video-audio-converter.ffmpeg.common.MediaType
import java.io.File

data class MediaQueue(
    val id: String,
    var status: QueueStatus = QueueStatus.NOT_STARTED,
    val input: InputMedia,
    val type: MediaType,
    val command: String,
    val outputFile: File,
    var startTime: String? = null,
    var finishTime: String? = null,
    var duration: String? = null,
    var error: Error? = null
)