package com.compose.presentation.screens.splashScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.compose.domain.usecase.SplashScreenUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashScreenViewModel @Inject constructor(private val useCase: SplashScreenUseCase): ViewModel() {
    private val _state = MutableStateFlow(
        SplashScreenState()
    )

    val state: StateFlow<SplashScreenState>
        get() = _state.asStateFlow()

    fun checkLogin(){
        viewModelScope.launch(Dispatchers.IO) {
            val token = useCase.getToken()
            if (!token.isNullOrBlank()){
                _state.tryEmit(_state.value.copy(skipAuth = true))
            }
        }
    }
}