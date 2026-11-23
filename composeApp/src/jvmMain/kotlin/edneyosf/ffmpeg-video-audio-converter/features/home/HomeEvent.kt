package edneyosf.ffmpeg-video-audio-converter.features.home

import androidx.compose.ui.draganddrop.DragAndDropEvent
import edneyosf.ffmpeg-video-audio-converter.features.home.states.HomeDialogState
import edneyosf.ffmpeg-video-audio-converter.features.home.states.HomeNavigationState

interface HomeEvent {
    fun setNavigation(state: HomeNavigationState) = Unit
    fun setDialog(state: HomeDialogState) = Unit
    fun onDragAndDropInput(event: DragAndDropEvent) = false
    fun setInputs(paths: List<String>) = Unit
    fun openLink(url: String) = Unit
}