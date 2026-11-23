package edneyosf.ffmpeg-video-audio-converter.core.utils

object PropertyUtils {
    val userHomeDir = System.getProperty("user.home") ?: ""
    val version: String? = System.getProperty("jpackage.app-version")
}