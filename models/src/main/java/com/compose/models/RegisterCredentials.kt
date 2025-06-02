package com.compose.models

import com.compose.utils.hmacSha256

data class RegisterCredentials(
    var name: String = "",
    var password: String = "",
    var passwordConfirmation: String = "",
    var email: String = "",

    var serializedPassword: String = "",
    var serializedPasswordConfirmation: String = ""
) {
    fun serialize(): RegisterCredentials{
        this.serializedPassword = password.hmacSha256()
        this.serializedPasswordConfirmation = passwordConfirmation.hmacSha256()
        this.password = ""
        this.passwordConfirmation = ""

        return this
    }
}
