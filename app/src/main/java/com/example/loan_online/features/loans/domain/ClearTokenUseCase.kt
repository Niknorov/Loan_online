package com.example.loan_online.features.loans.domain

import com.example.loan_online.features.auth.domain.repository.TokenRepository

class ClearTokenUseCase(
    private val tokenRepository: TokenRepository
) {
    operator fun invoke(): String {
        return tokenRepository.clearToken().toString()
    }
}