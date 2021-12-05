package com.example.loan_online.features.create.domain

import com.example.loan_online.features.create.data.CreationRepository

class PerformCreationUseCase(
    private val creationRepository: CreationRepository
) {

    suspend operator fun invoke(
        amount: Number, date: String, firstName: String, id: Int,
        lastName: String, percent: Number, period: Int, phoneNumber: String,
        state: LoanState
    ) {
        return creationRepository.performCreation(
            amount,
            date,
            firstName,
            id,
            lastName,
            percent,
            period,
            phoneNumber,
            state
        )

    }
}