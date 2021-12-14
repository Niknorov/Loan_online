package com.example.loan_online.features.loans.domain

import com.example.loan_online.features.create.domain.LoanModel

class GetLoansUseCase(
    private val loanRepository: LoanRepository
) {

    suspend operator fun invoke(): List<LoanModel> {

        return loanRepository.getLoans()

    }
}