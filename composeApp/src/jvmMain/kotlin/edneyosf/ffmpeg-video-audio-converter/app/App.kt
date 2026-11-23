package edneyosf.ffmpeg-video-audio-converter.app

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Warning
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.window.ApplicationScope
import androidx.compose.ui.window.Window
import ffmpeg-video-audio-converter.composeapp.generated.resources.Res
import ffmpeg-video-audio-converter.composeapp.generated.resources.icon
import edneyosf.ffmpeg-video-audio-converter.app.AppConfigs.MIN_WINDOW_HEIGHT
import edneyosf.ffmpeg-video-audio-converter.app.AppConfigs.MIN_WINDOW_WIDTH
import edneyosf.ffmpeg-video-audio-converter.app.extensions.getAvailableLanguage
import edneyosf.ffmpeg-video-audio-converter.core.process.EdProcess
import edneyosf.ffmpeg-video-audio-converter.features.common.CommonStrings.Keys.CANCEL_BUTTON
import edneyosf.ffmpeg-video-audio-converter.features.common.CommonStrings.Keys.CONFIRMATION_BUTTON
import edneyosf.ffmpeg-video-audio-converter.features.common.commonStrings
import edneyosf.ffmpeg-video-audio-converter.features.home.ui.HomeScreen
import edneyosf.ffmpeg-video-audio-converter.ui.components.dialogs.SimpleDialog
import edneyosf.ffmpeg-video-audio-converter.ui.compositions.languageComp
import edneyosf.ffmpeg-video-audio-converter.ui.compositions.strings
import edneyosf.ffmpeg-video-audio-converter.ui.compositions.stringsComp
import edneyosf.ffmpeg-video-audio-converter.ui.theme.AppTheme
import edneyosf.ffmpeg-video-audio-converter.app.ClosingDialogStrings.Keys.TITLE_CLOSING_DIALOG
import edneyosf.ffmpeg-video-audio-converter.app.ClosingDialogStrings.Keys.DESCRIPTION_CLOSING_DIALOG
import edneyosf.ffmpeg-video-audio-converter.ui.compositions.fileKitDialogSettingsComp
import edneyosf.ffmpeg-video-audio-converter.ui.previews.EnglishDarkPreview
import edneyosf.ffmpeg-video-audio-converter.ui.previews.EnglishLightPreview
import edneyosf.ffmpeg-video-audio-converter.ui.previews.PortugueseDarkPreview
import edneyosf.ffmpeg-video-audio-converter.ui.previews.PortugueseLightPreview
import edneyosf.ffmpeg-video-audio-converter.ui.theme.setWindowTheme
import io.github.vinceglb.filekit.dialogs.FileKitDialogSettings
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.koinInject
import java.awt.Dimension

@Composable
fun ApplicationScope.App() {
    val process: EdProcess = koinInject()
    val language = Locale.current.getAvailableLanguage()
    var showClosingDialog by mutableStateOf(value = false)

    Window(
        title = AppConfigs.NAME,
        onCloseRequest = {
            if(!process.isBusy()) exitApplication()
            else showClosingDialog = true
        },
        icon = painterResource(resource = Res.drawable.icon)
    ) {
        window.minimumSize = Dimension(MIN_WINDOW_WIDTH, MIN_WINDOW_HEIGHT)
        setWindowTheme(window)
        CompositionLocalProvider(
            languageComp provides language,
            fileKitDialogSettingsComp provides FileKitDialogSettings(parentWindow = window)
        ) {
            AppTheme {
                ClosingDialog(
                    show = showClosingDialog,
                    onDismiss = { showClosingDialog = false },
                    onExit = {
                        process.killAll()
                        exitApplication()
                    }
                )
                HomeScreen()
            }
        }
    }
}

@Composable
private fun ClosingDialog(show: Boolean, onExit: () -> Unit, onDismiss: () -> Unit) {
    if(show) {
        CompositionLocalProvider(value = stringsComp provides closingDialogStrings) {
            SimpleDialog(
                icon = Icons.Rounded.Warning,
                title = strings[TITLE_CLOSING_DIALOG],
                cancelText = commonStrings[CANCEL_BUTTON],
                confirmationText = commonStrings[CONFIRMATION_BUTTON],
                onCancel = onDismiss,
                onConfirmation = onExit,
                onDismissRequest = onDismiss,
                content = { Text(text = strings[DESCRIPTION_CLOSING_DIALOG]) }
            )
        }
    }
}

@Composable
private fun DefaultPreview() {
    ClosingDialog(show = true, onExit = {}, onDismiss = {})
}

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