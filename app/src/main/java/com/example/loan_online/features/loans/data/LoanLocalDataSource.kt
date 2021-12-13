package com.example.loan_online.features.loans.data

class LoanLocalDataSource(
    private val loanDao: LoanDao
) {

    suspend fun getLoan(): List<LoanEntity> {
        return loanDao.getLoan()
    }

    suspend fun insertLoan(loansList: List<LoanEntity>) {
        loanDao.insertLoans(loansList)
    }
}