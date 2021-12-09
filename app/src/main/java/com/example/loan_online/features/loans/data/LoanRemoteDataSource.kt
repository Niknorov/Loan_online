package com.example.loan_online.features.loans.data

class LoanRemoteDataSource(
    private val loansApi: LoansApi
) {

    suspend fun getLoans(token: String): List<LoanDTO> {

        return loansApi.getLoans(token)
    }

    suspend fun getLoanData(token: String, id: Int): LoanDTO {

        return loansApi.getData(token, id)
    }
}