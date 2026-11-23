package edneyosf.ffmpeg-video-audio-converter.ui.compositions

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf
import edneyosf.ffmpeg-video-audio-converter.core.common.Strings

val strings: Strings
    @Composable
    @ReadOnlyComposable
    get() = stringsComp.current

val stringsComp = compositionLocalOf<Strings> { error("No value provided for texts") }