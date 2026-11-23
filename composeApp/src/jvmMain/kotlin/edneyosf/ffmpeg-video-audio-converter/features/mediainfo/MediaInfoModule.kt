package edneyosf.ffmpeg-video-audio-converter.features.mediainfo

import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val mediaInfoModule = module {
    viewModel { MediaInfoViewModel(process = get()) }
}