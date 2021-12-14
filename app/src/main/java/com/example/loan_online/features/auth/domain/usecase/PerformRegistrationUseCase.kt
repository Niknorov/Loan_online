package com.example.loan_online.features.auth.domain.usecase

import com.example.loan_online.features.auth.domain.repository.AuthRepository

class PerformRegistrationUseCase(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(login: String, password: String) {

        return authRepository.performRegistration(login, password)
    }

}