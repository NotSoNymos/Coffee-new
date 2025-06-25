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
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(val useCase: RegisterUseCase?) : ViewModel() {
    private val _credentials = mutableStateOf(RegisterCredentials()).value
    private val _state = MutableStateFlow(
        RegisterState()
    )

    val state: StateFlow<RegisterState>
        get() = _state.asStateFlow()

    fun setName(name: String) {
        _credentials.name = name
    }

    fun setEmail(email: String) {
        _credentials.email = email
    }

    fun setPassword(password: String) {
        _credentials.password = password
    }

    fun setPasswordConfirmation(passwordConfirmation: String) {
        _credentials.passwordConfirmation = passwordConfirmation
    }

    fun register() {
        viewModelScope.launch(Dispatchers.IO) {
            _state.update { v -> v.copy(isLoading = true) }
            //_state.emit(_state.value.copy(isLoading = true))
            useCase?.register(_credentials)
        }
    }
}