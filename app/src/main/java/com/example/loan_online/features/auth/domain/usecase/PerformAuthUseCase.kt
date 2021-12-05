package com.example.loan_online.features.auth.domain.usecase

import com.example.loan_online.features.auth.data.AuthRepository
import com.example.loan_online.features.auth.data.AuthRequest

class PerformAuthUseCase(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(login: String, password: String) {

        authRepository.performAuth(login, password)
    }
}
