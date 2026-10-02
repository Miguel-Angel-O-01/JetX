package com.example.jetx.presentation.screen.home

data class HomeUiState(
    val isLoading: Boolean = false,
    val message: String = "Bienvenido a JetX",
    val error: String? = null
)