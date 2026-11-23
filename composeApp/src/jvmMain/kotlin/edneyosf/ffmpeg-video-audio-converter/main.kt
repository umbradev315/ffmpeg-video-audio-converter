package edneyosf.ffmpeg-video-audio-converter

import androidx.compose.ui.window.application
import edneyosf.ffmpeg-video-audio-converter.app.App
import edneyosf.ffmpeg-video-audio-converter.app.AppConfigs
import edneyosf.ffmpeg-video-audio-converter.core.coreModule
import edneyosf.ffmpeg-video-audio-converter.features.console.consoleModule
import edneyosf.ffmpeg-video-audio-converter.features.converter.converterModule
import edneyosf.ffmpeg-video-audio-converter.features.home.homeFeatureModule
import edneyosf.ffmpeg-video-audio-converter.features.mediainfo.mediaInfoModule
import edneyosf.ffmpeg-video-audio-converter.features.queue.queueFeatureModule
import edneyosf.ffmpeg-video-audio-converter.features.settings.settingsFeatureModule
import edneyosf.ffmpeg-video-audio-converter.features.metrics.metricsFeatureModule
import io.github.vinceglb.filekit.FileKit
import org.koin.core.context.GlobalContext.startKoin

fun main() {
    startKoin {
        modules(modules = coreModule)
        modules(modules = homeFeatureModule)
        modules(modules = settingsFeatureModule)
        modules(modules = converterModule)
        modules(modules = queueFeatureModule)
        modules(modules = mediaInfoModule)
        modules(modules = metricsFeatureModule)
        modules(modules = consoleModule)
    }
    System.setProperty("apple.awt.application.appearance", "system")
    FileKit.init(appId = AppConfigs.NAME)
    application { App() }
}