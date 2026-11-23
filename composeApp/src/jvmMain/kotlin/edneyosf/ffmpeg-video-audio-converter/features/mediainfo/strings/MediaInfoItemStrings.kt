package edneyosf.ffmpeg-video-audio-converter.features.mediainfo.strings

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import edneyosf.ffmpeg-video-audio-converter.core.common.Languages.EN
import edneyosf.ffmpeg-video-audio-converter.core.common.Languages.PT
import edneyosf.ffmpeg-video-audio-converter.core.common.Strings
import edneyosf.ffmpeg-video-audio-converter.ui.compositions.language
import edneyosf.ffmpeg-video-audio-converter.features.mediainfo.strings.MediaInfoItemStrings.Keys.*

inline val mediaInfoItemStrings: MediaInfoItemStrings
    @ReadOnlyComposable
    @Composable
    get() = MediaInfoItemStrings(language)

class MediaInfoItemStrings(override val language: String): Strings(language) {

    override val pt = mapOf(
        AUDIO to "Áudio",
        VIDEO to "Vídeo",
        SUBTITLE to "Legenda",
        REMOVE to "Remover"
    )

    override val en = mapOf(
        AUDIO to "Audio",
        VIDEO to "Video",
        SUBTITLE to "Subtitle",
        REMOVE to "Remove"
    )

    override val texts = mapOf(PT to pt, EN to en)

    enum class Keys {
        AUDIO,
        VIDEO,
        SUBTITLE,
        REMOVE
    }
}