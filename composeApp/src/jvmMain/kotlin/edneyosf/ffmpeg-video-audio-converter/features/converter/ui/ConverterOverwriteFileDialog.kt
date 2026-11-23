package edneyosf.ffmpeg-video-audio-converter.features.converter.ui

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Warning
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import edneyosf.ffmpeg-video-audio-converter.features.common.commonStrings
import edneyosf.ffmpeg-video-audio-converter.features.common.CommonStrings.Keys.WARNING_TITLE
import edneyosf.ffmpeg-video-audio-converter.features.common.CommonStrings.Keys.CANCEL_BUTTON
import edneyosf.ffmpeg-video-audio-converter.features.common.CommonStrings.Keys.CONFIRMATION_BUTTON
import edneyosf.ffmpeg-video-audio-converter.features.converter.strings.ConverterOverwriteFileDialogStrings.Keys.DESCRIPTION
import edneyosf.ffmpeg-video-audio-converter.features.converter.strings.converterOverwriteFileDialogStrings
import edneyosf.ffmpeg-video-audio-converter.ui.components.dialogs.SimpleDialog
import edneyosf.ffmpeg-video-audio-converter.ui.compositions.strings
import edneyosf.ffmpeg-video-audio-converter.ui.compositions.stringsComp
import edneyosf.ffmpeg-video-audio-converter.ui.previews.EnglishDarkPreview
import edneyosf.ffmpeg-video-audio-converter.ui.previews.EnglishLightPreview
import edneyosf.ffmpeg-video-audio-converter.ui.previews.PortugueseDarkPreview
import edneyosf.ffmpeg-video-audio-converter.ui.previews.PortugueseLightPreview

@Composable
fun ConverterOverwriteFileDialog(onCancel: () -> Unit, onConfirmation: () -> Unit) {
    CompositionLocalProvider(value = stringsComp provides converterOverwriteFileDialogStrings) {
        SimpleDialog(
            icon = Icons.Rounded.Warning,
            title = commonStrings[WARNING_TITLE],
            content = { Text(text = strings[DESCRIPTION]) },
            confirmationText = commonStrings[CONFIRMATION_BUTTON],
            onConfirmation = onConfirmation,
            cancelText = commonStrings[CANCEL_BUTTON],
            onCancel = onCancel
        )
    }
}

@Composable
private fun DefaultPreview() = ConverterOverwriteFileDialog(onConfirmation = {}, onCancel = {})

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