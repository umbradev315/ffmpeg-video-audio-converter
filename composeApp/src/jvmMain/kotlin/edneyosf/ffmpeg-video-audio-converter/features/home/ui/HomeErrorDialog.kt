package edneyosf.ffmpeg-video-audio-converter.features.home.ui

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Error
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import edneyosf.ffmpeg-video-audio-converter.core.common.Error
import edneyosf.ffmpeg-video-audio-converter.features.common.CommonStrings.Keys.ERROR_TITLE
import edneyosf.ffmpeg-video-audio-converter.features.common.CommonStrings.Keys.CONFIRMATION_BUTTON
import edneyosf.ffmpeg-video-audio-converter.features.common.CommonStrings.Keys.ERROR_DEFAULT
import edneyosf.ffmpeg-video-audio-converter.features.common.commonStrings
import edneyosf.ffmpeg-video-audio-converter.features.home.strings.homeErrorDialogStrings
import edneyosf.ffmpeg-video-audio-converter.features.home.strings.HomeErrorDialogStrings.Keys.*
import edneyosf.ffmpeg-video-audio-converter.ui.components.dialogs.SimpleDialog
import edneyosf.ffmpeg-video-audio-converter.ui.compositions.strings
import edneyosf.ffmpeg-video-audio-converter.ui.compositions.stringsComp
import edneyosf.ffmpeg-video-audio-converter.ui.previews.EnglishDarkPreview
import edneyosf.ffmpeg-video-audio-converter.ui.previews.EnglishLightPreview
import edneyosf.ffmpeg-video-audio-converter.ui.previews.PortugueseDarkPreview
import edneyosf.ffmpeg-video-audio-converter.ui.previews.PortugueseLightPreview

@Composable
fun HomeErrorDialog(error: Error, onFinish: () -> Unit) {
    CompositionLocalProvider(value = stringsComp provides homeErrorDialogStrings) {
        val description = when(error) {
            Error.LOAD_CONFIGS -> strings[LOAD_CONFIGS]
            Error.UNKNOWN_INPUT_MEDIA -> strings[UNKNOWN_INPUT_MEDIA]
            Error.NO_DURATION_INPUT_MEDIA -> strings[NO_DURATION_INPUT_MEDIA]
            Error.NO_STREAM_FOUND_INPUT_MEDIA -> strings[NO_STREAM_FOUND_INPUT_MEDIA]
            Error.NO_CHANNELS_INPUT_MEDIA -> strings[NO_CHANNELS_INPUT_MEDIA]
            Error.NO_RESOLUTION_INPUT_MEDIA -> strings[NO_RESOLUTION_INPUT_MEDIA]
            Error.OPEN_LINK -> strings[OPEN_LINK]
            else -> commonStrings[ERROR_DEFAULT]
        }

        SimpleDialog(
            icon = Icons.Rounded.Error,
            iconDescription = error.code,
            title = commonStrings[ERROR_TITLE],
            content = {
                Text(
                    text = description,
                    style = TextStyle(textAlign = TextAlign.Center)
                )
            },
            onConfirmation = onFinish,
            confirmationText = commonStrings[CONFIRMATION_BUTTON]
        )
    }
}

@Composable
private fun DefaultPreview() = HomeErrorDialog(error = Error.DEFAULT, onFinish = {})

@Preview
@Composable
private fun EnglishLight() = EnglishLightPreview { DefaultPreview() }

@Preview
@Composable
private fun EnglishDark() = EnglishDarkPreview { DefaultPreview() }

@Preview
@Composable
private fun PortugueseLight() = PortugueseLightPreview { DefaultPreview() }

@Preview
@Composable
private fun PortugueseDark() = PortugueseDarkPreview { DefaultPreview() }