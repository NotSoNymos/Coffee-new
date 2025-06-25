package com.compose.models

data class RegisterCredentials(
    var name: String = "",
    var password: String = "",
    var passwordConfirmation: String = "",
    var email: String = "",
)
