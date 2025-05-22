package com.compose.domain.usecase

import com.compose.domain.repository.DomainRepositoryImpl
import javax.inject.Inject

class SplashScreenUseCase @Inject constructor(private val domainRepositoryImpl: DomainRepositoryImpl) {
    suspend fun getToken(): String? {
        return "" //TODO
    }
}