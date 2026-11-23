package edneyosf.ffmpeg-video-audio-converter.features.converter.ui

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Error
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import edneyosf.ffmpeg-video-audio-converter.core.common.Error
import edneyosf.ffmpeg-video-audio-converter.features.common.CommonStrings.Keys.ERROR_TITLE
import edneyosf.ffmpeg-video-audio-converter.features.common.CommonStrings.Keys.CONFIRMATION_BUTTON
import edneyosf.ffmpeg-video-audio-converter.features.common.commonStrings
import edneyosf.ffmpeg-video-audio-converter.features.converter.extensions.toConverterDescription
import edneyosf.ffmpeg-video-audio-converter.features.converter.strings.converterErrorDialogStrings
import edneyosf.ffmpeg-video-audio-converter.ui.components.dialogs.SimpleDialog
import edneyosf.ffmpeg-video-audio-converter.ui.compositions.stringsComp
import edneyosf.ffmpeg-video-audio-converter.ui.previews.EnglishDarkPreview
import edneyosf.ffmpeg-video-audio-converter.ui.previews.EnglishLightPreview
import edneyosf.ffmpeg-video-audio-converter.ui.previews.PortugueseDarkPreview
import edneyosf.ffmpeg-video-audio-converter.ui.previews.PortugueseLightPreview

@Composable
fun ConverterErrorDialog(error: Error, onFinish: () -> Unit) {
    CompositionLocalProvider(value = stringsComp provides converterErrorDialogStrings) {
        SimpleDialog(
            icon = Icons.Rounded.Error,
            iconDescription = error.code,
            title = commonStrings[ERROR_TITLE],
            content = { Text(text = error.toConverterDescription()) },
            onConfirmation = onFinish,
            confirmationText = commonStrings[CONFIRMATION_BUTTON]
        )
    }
}

@Composable
private fun DefaultPreview() = ConverterErrorDialog(Error.CONVERSION_PROCESS, onFinish = {})

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