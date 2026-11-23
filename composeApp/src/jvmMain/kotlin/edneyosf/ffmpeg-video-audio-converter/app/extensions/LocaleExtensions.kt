package edneyosf.ffmpeg-video-audio-converter.app.extensions

import edneyosf.ffmpeg-video-audio-converter.core.common.Languages
import androidx.compose.ui.text.intl.Locale
import edneyosf.ffmpeg-video-audio-converter.app.AppConfigs

fun Locale.getAvailableLanguage() = when(val currentLanguage = this.language) {
    Languages.PT, Languages.EN -> currentLanguage
    else -> AppConfigs.LANGUAGE
}