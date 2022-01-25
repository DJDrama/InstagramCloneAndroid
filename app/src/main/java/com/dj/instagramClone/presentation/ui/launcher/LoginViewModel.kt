package com.dj.instagramClone.presentation.ui.launcher

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class LoginViewModel : ViewModel() {

    private var id: String? = null
    private var password: String? = null

    private val _credentialUiState =
        MutableStateFlow<CredentialUiState>(CredentialUiState.BothNotFilled)
    val credentialUiState = _credentialUiState.asStateFlow()

    fun setCredentials(id: String? = null, password: String? = null) {
        id?.let {
            this.id = it
        }
        password?.let {
            this.password = it
        }

        if (!this.id.isNullOrBlank() && !this.password.isNullOrBlank()) {
            _credentialUiState.value = CredentialUiState.BothFilled
        } else {
            _credentialUiState.value = CredentialUiState.BothNotFilled
        }
    }
}

sealed class CredentialUiState {
    object BothFilled : CredentialUiState()
    object BothNotFilled : CredentialUiState()
}
