package com.example.loan_online.features.loans.domain

import com.example.loan_online.features.create.domain.LoanModel
import com.example.loan_online.features.loans.data.LoanRepository

class GetLoanDataUseCase(
    private val loanRepository: LoanRepository
) {
    suspend operator fun invoke(id: Int): LoanModel {

        return loanRepository.getLoanData(id)
    }

}