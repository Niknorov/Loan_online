package com.example.loan_online.features.splash.data

import com.example.loan_online.features.auth.data.TokenLocalDataSource

class TokenRepository(
    private val tokenLocalDataSource: TokenLocalDataSource
) {

    fun getToken(): String {
        return tokenLocalDataSource.getToken()
    }

}