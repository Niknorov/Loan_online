package com.example.loan_online.features.splash.domain

import com.example.loan_online.features.splash.data.TokenRepository

class GetTokenUseCase(
    private val tokenRepository: TokenRepository
) {

    operator fun invoke(): String {
        return tokenRepository.getToken()

    }
}