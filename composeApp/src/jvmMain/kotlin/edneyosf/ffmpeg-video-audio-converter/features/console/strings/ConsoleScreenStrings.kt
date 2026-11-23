package edneyosf.ffmpeg-video-audio-converter.features.console.strings

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import edneyosf.ffmpeg-video-audio-converter.core.common.Languages.EN
import edneyosf.ffmpeg-video-audio-converter.core.common.Languages.PT
import edneyosf.ffmpeg-video-audio-converter.core.common.Strings
import edneyosf.ffmpeg-video-audio-converter.ui.compositions.language
import edneyosf.ffmpeg-video-audio-converter.features.console.strings.ConsoleScreenStrings.Keys.*

inline val consoleScreenStrings: ConsoleScreenStrings
    @ReadOnlyComposable
    @Composable
    get() = ConsoleScreenStrings(language)

class ConsoleScreenStrings(override val language: String): Strings(language) {

    override val pt = mapOf(
        TITLE to "Console",
        COMMAND_INPUT to "Comando",
        EMPTY_LOGS to "Sem registros"
    )

    override val en = mapOf(
        TITLE to "Console",
        COMMAND_INPUT to "Command",
        EMPTY_LOGS to "No logs"
    )

    override val texts = mapOf(PT to pt, EN to en)

    enum class Keys {
        TITLE,
        COMMAND_INPUT,
        EMPTY_LOGS
    }
}