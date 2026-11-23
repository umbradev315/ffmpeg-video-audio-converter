package edneyosf.ffmpeg-video-audio-converter.features.converter.states

import edneyosf.ffmpeg-video-audio-converter.features.converter.enums.ConverterFileExistsAction

sealed interface ConverterDialogState {
    data object None: ConverterDialogState
    data object Settings: ConverterDialogState
    data class FileExists(val action: ConverterFileExistsAction): ConverterDialogState
}