package com.example.loan_online.features.auth.domain.usecase

import com.example.loan_online.features.auth.domain.repository.TokenRepository

class GetTokenUseCase(
    private val tokenRepository: TokenRepository
) {

    operator fun invoke(): String {
        return tokenRepository.getToken()

    }
}