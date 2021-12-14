package com.example.loan_online.features.auth.domain.usecase

import com.example.loan_online.features.auth.domain.repository.AuthRepository

class PerformAuthUseCase(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(login: String, password: String) {

        authRepository.performAuth(login, password)
    }
}
