package com.example.loan_online.features.create.data

import com.example.loan_online.features.create.domain.LoanState

class CreationRepository(
    private val creationRemoteDataSource: CreationRemoteDataSource,
) {

    suspend fun performCreation(
        amount: Number, date: String, firstName: String, id: Int,
        lastName: String, percent: Number, period: Int, phoneNumber: String, state: LoanState
    ) {
        creationRemoteDataSource.performCreation(
            CreationRequest(
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
        )

    }
}