package com.example.jetx.presentation.screen.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState: StateFlow<LoginUiState> = _uiState.asStateFlow()

    fun onUsernameChanged(input: String) {
        _uiState.value = _uiState.value.copy(username = input, errorMessage = null)
    }

    fun onPasswordChanged(input: String) {
        _uiState.value = _uiState.value.copy(password = input, errorMessage = null)
    }

    fun login(onSuccess: () -> Unit) {
        val current = _uiState.value
        if (current.username.isBlank() || current.password.isBlank()) {
            _uiState.value = current.copy(errorMessage = "Por favor completa todos los campos")
            return
        }

        viewModelScope.launch {
            _uiState.value = current.copy(isLoading = true, errorMessage = null)
            delay(1500)
            _uiState.value = _uiState.value.copy(isLoading = false)
            onSuccess()
        }
    }
}