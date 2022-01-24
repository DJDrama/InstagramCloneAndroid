package com.dj.instagramClone.presentation.ui.launcher

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class IntroViewModel: ViewModel() {

    private val _introUiState = MutableStateFlow<IntroUiState>(IntroUiState.Loading)
    val introUiState = _introUiState.asStateFlow()

    init{
        initApp()
    }

    private fun initApp(){
        viewModelScope.launch {
            delay(2000)
            _introUiState.value = IntroUiState.LoadComplete
        }
    }

}

sealed class IntroUiState {
    object LoadComplete: IntroUiState()
    object Loading: IntroUiState()
}
