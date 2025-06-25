package com.compose.presentation.screens.onboardingScreen.registerScreen

data class RegisterState(
    val isLoading: Boolean = false,
    val isSuccessful: Boolean = false,
    val error: String? = null
)