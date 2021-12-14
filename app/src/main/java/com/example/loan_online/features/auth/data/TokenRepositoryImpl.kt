package com.example.loan_online.features.auth.data

import com.example.loan_online.features.auth.domain.repository.TokenRepository

class TokenRepositoryImpl(
    private val tokenLocalDataSource: TokenLocalDataSource
) : TokenRepository {

    override fun getToken(): String {
        return tokenLocalDataSource.getToken()
    }

    override fun clearToken() {
        return tokenLocalDataSource.clearToken()
    }

}