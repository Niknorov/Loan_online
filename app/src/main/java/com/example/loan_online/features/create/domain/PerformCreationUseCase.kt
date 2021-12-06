package com.example.loan_online.features.create.domain

import com.example.loan_online.features.create.data.CreationRepository

class PerformCreationUseCase(
    private val creationRepository: CreationRepository
) {

    suspend operator fun invoke(
        amount: Number, firstName: String,
        lastName: String, percent: Number, period: Int, phoneNumber: String
    ): LoanModel {
        return creationRepository.performCreation(
            amount,
            firstName,
            lastName,
            percent,
            period,
            phoneNumber,
            )

    }
}