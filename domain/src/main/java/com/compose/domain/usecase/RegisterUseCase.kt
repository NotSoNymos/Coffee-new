package com.compose.domain.usecase

import android.util.Log
import com.compose.data.models.CatData
import com.compose.domain.repository.DomainRepositoryImpl
import com.compose.models.RegisterCredentials
import javax.inject.Inject

class RegisterUseCase @Inject constructor(private val domainRepositoryImpl: DomainRepositoryImpl) {
    suspend fun register(credentials: RegisterCredentials): CatData {
        val data = domainRepositoryImpl.register()
        Log.e("12345", data.url)
        Log.e("test", credentials.toString())
        return data
    }
}