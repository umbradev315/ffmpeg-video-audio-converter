package edneyosf.ffmpeg-video-audio-converter.ui.compositions

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf
import edneyosf.ffmpeg-video-audio-converter.core.common.Languages

inline val language: String
    @Composable
    @ReadOnlyComposable
    get() = languageComp.current

val languageComp = compositionLocalOf { Languages.EN }