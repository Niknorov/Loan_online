package com.example.loan_online.features.loans.data

import com.example.loan_online.features.auth.data.TokenLocalDataSource
import com.example.loan_online.features.create.domain.LoanModel
import com.example.loan_online.features.create.domain.LoanState
import com.example.loan_online.features.loans.domain.LoanRepository
import java.lang.Exception
import java.lang.IllegalArgumentException

class LoanRepositoryImpl(
    private val loanRemoteDataSource: LoanRemoteDataSource,
    private val tokenLocalDataSource: TokenLocalDataSource,
    private val loanLocalDataSource: LoanLocalDataSource
) : LoanRepository {

    override suspend fun getLoans(): List<LoanModel> {
        try {
            val loanEntityList =
                loanRemoteDataSource.getLoans(tokenLocalDataSource.getToken()).map {

                    LoanEntity(
                        amount = it.amount,
                        date = it.date,
                        firstName = it.firstName,
                        id = it.id,
                        lastName = it.lastName,
                        percent = it.percent,
                        period = it.period,
                        phoneNumber = it.phoneNumber,
                        state = it.state
                    )
                }

            loanLocalDataSource.insertLoan(loanEntityList)
            return loanEntityList.map {
                LoanModel(
                    it.amount,
                    it.date,
                    it.firstName,
                    it.id,
                    it.lastName,
                    it.percent,
                    it.period,
                    it.phoneNumber,
                    state = when (it.state) {
                        "APPROVED" -> LoanState.APPROVED
                        "REGISTERED" -> LoanState.REGISTERED
                        "REJECTED" -> LoanState.REJECTED
                        else -> throw IllegalArgumentException()
                    }
                )
            }

        } catch (e: Exception) {
            return loanLocalDataSource.getLoan().map {
                LoanModel(
                    it.amount,
                    it.date,
                    it.firstName,
                    it.id,
                    it.lastName,
                    it.percent,
                    it.period,
                    it.phoneNumber,
                    state = when (it.state) {
                        "APPROVED" -> LoanState.APPROVED
                        "REGISTERED" -> LoanState.REGISTERED
                        "REJECTED" -> LoanState.REJECTED
                        else -> throw IllegalArgumentException()
                    }
                )
            }

        }
    }

    override suspend fun getLoanData(
        id: Int
    ): LoanModel {

        val loanData = loanRemoteDataSource.getLoanData(tokenLocalDataSource.getToken(), id)

        return LoanModel(
            amount = loanData.amount,
            date = loanData.date,
            firstName = loanData.firstName,
            id = loanData.id,
            lastName = loanData.lastName,
            percent = loanData.percent,
            period = loanData.period,
            phoneNumber = loanData.phoneNumber,
            state = when (loanData.state) {
                "APPROVED" -> LoanState.APPROVED
                "REGISTERED" -> LoanState.REGISTERED
                "REJECTED" -> LoanState.REJECTED
                else -> throw IllegalArgumentException()
            }
        )
    }
}