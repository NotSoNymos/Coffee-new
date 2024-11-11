package com.compose.data.repository

import com.compose.data.utils.Provider
import javax.inject.Inject

class DataRepositoryImpl @Inject constructor(): DataRepository {
    override suspend fun getTest() {
        Provider.provideRetrofit().getRandomCat()
    }
}