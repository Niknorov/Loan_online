package com.example.loan_online.features.loans.domain

import com.example.loan_online.features.create.domain.LoanModel

interface LoanRepository {

    suspend fun getLoans(): List<LoanModel>

    suspend fun getLoanData(
        id: Int
    ): LoanModel
}