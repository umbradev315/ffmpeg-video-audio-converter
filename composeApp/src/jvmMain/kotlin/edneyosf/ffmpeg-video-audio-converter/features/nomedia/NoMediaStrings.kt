package edneyosf.ffmpeg-video-audio-converter.features.nomedia

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import edneyosf.ffmpeg-video-audio-converter.core.common.Languages.EN
import edneyosf.ffmpeg-video-audio-converter.core.common.Languages.PT
import edneyosf.ffmpeg-video-audio-converter.core.common.Strings
import edneyosf.ffmpeg-video-audio-converter.ui.compositions.language
import edneyosf.ffmpeg-video-audio-converter.features.nomedia.NoMediaScreenStrings.Keys.*

inline val noMediaScreenStrings: NoMediaScreenStrings
    @ReadOnlyComposable
    @Composable
    get() = NoMediaScreenStrings(language)

class NoMediaScreenStrings(override val language: String): Strings(language) {

    override val pt = mapOf(
        NO_FILE_SELECTED to "Arraste ou selecione um arquivo de mídia"
    )

    override val en = mapOf(
        NO_FILE_SELECTED to "Drag or select a media file"
    )

    override val texts = mapOf(PT to pt, EN to en)

    enum class Keys {
        NO_FILE_SELECTED
    }
}