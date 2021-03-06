package com.example.loan_online.features.create.domain

class CreateLoanUseCase(
    private val creationRepository: CreationRepository
) {

    suspend operator fun invoke(
        amount: Double, firstName: String,
        lastName: String, percent: Double, period: Int, phoneNumber: String
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