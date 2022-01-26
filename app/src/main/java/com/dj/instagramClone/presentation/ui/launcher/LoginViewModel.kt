package com.dj.instagramClone.presentation.ui.launcher

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

    private var id: String? = null
    private var password: String? = null

    private val _credentialUiState =
        MutableStateFlow<CredentialUiState>(CredentialUiState.BothNotFilled)
    val credentialUiState = _credentialUiState.asStateFlow()

    private val _createNewAccountState= MutableStateFlow<CreateNewAccountState>(CreateNewAccountState.FirstTime)
    val createNewAccountState = _createNewAccountState.asStateFlow()

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

    fun onCreateNewAccountClicked(){
        viewModelScope.launch {
            _createNewAccountState.value = CreateNewAccountState.NotFirstTime
        }
    }

}

sealed class CredentialUiState {
    object BothFilled : CredentialUiState()
    object BothNotFilled : CredentialUiState()
}

sealed class CreateNewAccountState {
    object NotFirstTime: CreateNewAccountState()
    object FirstTime: CreateNewAccountState()
}
