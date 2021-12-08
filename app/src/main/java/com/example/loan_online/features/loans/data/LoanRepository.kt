package com.example.loan_online.features.loans.data

import com.example.loan_online.features.auth.data.TokenLocalDataSource
import com.example.loan_online.features.create.domain.LoanModel
import com.example.loan_online.features.create.domain.LoanState
import java.lang.IllegalArgumentException

class LoanRepository(
    private val loanRemoteDataSource: LoanRemoteDataSource,
    private val tokenLocalDataSource: TokenLocalDataSource
) {

    suspend fun getLoans(): List<LoanModel> {


        val loanList = loanRemoteDataSource.getLoans(tokenLocalDataSource.getToken()).map {

            LoanModel(
                amount = it.amount,
                date = it.date,
                firstName = it.firstName,
                id = it.id,
                lastName = it.lastName,
                percent = it.percent,
                period = it.period,
                phoneNumber = it.phoneNumber,
                state = when (it.state) {
                    "APPROVED" -> LoanState.APPROVED
                    "REGISTERED" -> LoanState.REGISTERED
                    "REJECTED" -> LoanState.REJECTED
                    else -> throw IllegalArgumentException()
                }

            )

        }
        return loanList
    }

}