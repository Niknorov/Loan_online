package com.example.loan_online.features.loans.domain

import com.example.loan_online.features.create.domain.LoanModel

class GetLoanDataUseCase(
    private val loanRepository: LoanRepository
) {
    suspend operator fun invoke(id: Int): LoanModel {

        return loanRepository.getLoanData(id)
    }

}