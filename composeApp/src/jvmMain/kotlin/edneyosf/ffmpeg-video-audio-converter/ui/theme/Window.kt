package edneyosf.ffmpeg-video-audio-converter.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.awt.ComposeWindow
import com.sun.jna.Native
import com.sun.jna.Pointer
import com.sun.jna.platform.win32.WinDef.HWND
import edneyosf.ffmpeg-video-audio-converter.core.common.OS
import edneyosf.ffmpeg-video-audio-converter.core.utils.PlatformUtils
import edneyosf.ffmpeg-video-audio-converter.core.windows.DwmAttribute
import edneyosf.ffmpeg-video-audio-converter.core.windows.setWindowAttribute
import java.awt.Window

@Composable
fun setWindowTheme(window: Window, darkTheme: Boolean = isSystemInDarkTheme()) {
    if(PlatformUtils.current == OS.WINDOWS) {
        window.hwnd.run {
            setWindowAttribute(
                attribute = DwmAttribute.DWMWA_USE_IMMERSIVE_DARK_MODE_BEFORE_20H1,
                value = darkTheme
            )
            setWindowAttribute(
                attribute = DwmAttribute.DWMWA_USE_IMMERSIVE_DARK_MODE,
                value = darkTheme
            )
        }
    }
}

val Window.hwnd
    get() =
        if (this is ComposeWindow) HWND(Pointer(windowHandle))
        else HWND(Native.getWindowPointer(this))