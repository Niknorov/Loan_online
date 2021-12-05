package com.example.loan_online.features.auth.domain.usecase

import com.example.loan_online.features.auth.data.AuthRepository
import com.example.loan_online.features.auth.data.AuthRequest

class PerformRegistrationUseCase(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(login: String, password: String) {

        return authRepository.performRegistration(login, password)
    }

}