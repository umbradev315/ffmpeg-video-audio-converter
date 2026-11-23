package edneyosf.ffmpeg-video-audio-converter.core.config

import edneyosf.ffmpeg-video-audio-converter.app.AppConfigs
import edneyosf.ffmpeg-video-audio-converter.core.common.OS
import edneyosf.ffmpeg-video-audio-converter.core.utils.PlatformUtils
import edneyosf.ffmpeg-video-audio-converter.core.utils.PropertyUtils
import kotlinx.serialization.json.Json
import java.io.File

open class ConfigManager(private val fileName: String) {

    protected lateinit var configFile: File
    protected lateinit var config: Config

    fun load() {
        configFile = File(configDir(), fileName)

        config = if (configFile.exists()) Json.Default.decodeFromString(string = configFile.readText())
        else Config()
    }

    protected inline fun save(crossinline block: Config.() -> Unit) {
        config.block()
        configFile.writeText(text = Json.encodeToString(value = config))
    }

    private fun configDir(): File {
        val baseDir = when(PlatformUtils.current) {
            OS.WINDOWS -> "${PropertyUtils.userHomeDir}\\AppData\\Roaming"
            OS.MACOS -> "${PropertyUtils.userHomeDir}/Library/Application Support"
            else -> "${PropertyUtils.userHomeDir}/.config"
        }

        return File(baseDir, AppConfigs.NAME).also { it.mkdirs() }
    }
}