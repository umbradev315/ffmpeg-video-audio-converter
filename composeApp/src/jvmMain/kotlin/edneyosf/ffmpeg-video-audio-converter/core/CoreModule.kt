package edneyosf.ffmpeg-video-audio-converter.core

import edneyosf.ffmpeg-video-audio-converter.core.config.EdConfig
import edneyosf.ffmpeg-video-audio-converter.core.config.RemoteConfig
import edneyosf.ffmpeg-video-audio-converter.core.process.EdProcess
import org.koin.dsl.module

val coreModule = module {
    single { EdConfig() }
    single { RemoteConfig() }
    single { EdProcess() }
}