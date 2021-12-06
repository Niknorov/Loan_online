package com.example.loan_online.features.create.data

import com.example.loan_online.features.create.domain.LoanModel
import com.example.loan_online.features.create.domain.LoanState
import java.lang.IllegalArgumentException

class CreationRepository(
    private val creationRemoteDataSource: CreationRemoteDataSource,
) {

    suspend fun performCreation(
        amount: Number,
        firstName: String,
        lastName: String,
        percent: Number,
        period: Int,
        phoneNumber: String,
    ): LoanModel {


        val response = creationRemoteDataSource.performCreation(
            CreationRequest(
                amount = amount,
                firstName = firstName,
                lastName = lastName,
                percent = percent,
                period = period,
                phoneNumber = phoneNumber
            )
        )

        return LoanModel(
            amount = response.amount,
            date = response.date,
            firstName = response.firstName,
            id = response.id,
            lastName = response.lastName,
            percent = response.percent,
            period = response.period,
            phoneNumber = response.phoneNumber,
            state = when (response.state) {
                "APPROVED" -> LoanState.APPROVED
                "REGISTERED" -> LoanState.REGISTERED
                "REJECTED" -> LoanState.REJECTED
                else -> throw IllegalArgumentException()
            }
        )
    }
}