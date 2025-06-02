package com.compose.presentation.screens.onboardingScreen.registerScreen

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.compose.domain.usecase.RegisterUseCase
import com.compose.models.RegisterCredentials
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(val useCase: RegisterUseCase) : ViewModel() {
    private val _credentials = mutableStateOf(RegisterCredentials()).value
    private val _state = MutableStateFlow<RegisterState>(
        RegisterState()
    )

    val state: StateFlow<RegisterState>
        get() = _state.asStateFlow()

    val setName = { name: String -> _credentials.name = name }

    val setEmail = { email: String -> _credentials.email = email }

    val setPassword = { password: String -> _credentials.password = password }

    val setPasswordConfirmation =
        { passwordConfirmation: String -> _credentials.passwordConfirmation = passwordConfirmation }

    fun register() =
        viewModelScope.launch(Dispatchers.IO) { useCase.register(_credentials.serialize()) }
}