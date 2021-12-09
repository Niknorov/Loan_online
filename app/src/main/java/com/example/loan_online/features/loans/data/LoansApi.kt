package com.example.loan_online.features.loans.data

import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface LoansApi {


    @GET(value = "/loans/all")
    suspend fun getLoans(
        @Header("Authorization") token: String
    ): List<LoanDTO>


    @GET(value = "/loans/{id}")
    suspend fun getData(
        @Header("Authorization") token: String,
        @Path("id") id: Int
    ): LoanDTO
}