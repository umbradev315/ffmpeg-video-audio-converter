package edneyosf.ffmpeg-video-audio-converter.ui.filekit

class PickerResultLauncher(private val onLaunch: () -> Unit) {
    fun launch() { onLaunch() }
}