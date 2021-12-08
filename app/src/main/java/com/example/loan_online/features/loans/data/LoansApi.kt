package com.example.loan_online.features.loans.data

import retrofit2.http.GET
import retrofit2.http.Header

interface LoansApi {


    @GET(value = "/loans/all")
    suspend fun getLoans(
        @Header("Authorization") token: String
    ): List<LoanDTO>

}