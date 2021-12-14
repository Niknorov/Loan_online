package com.example.loan_online.features.create.domain

interface CreationRepository {

    suspend fun performCreation(
        amount: Double,
        firstName: String,
        lastName: String,
        percent: Double,
        period: Int,
        phoneNumber: String,
    ): LoanModel

    suspend fun getConditions(): ConditionsModel
}