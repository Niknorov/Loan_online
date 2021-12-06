package com.example.loan_online.features.create.data

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface CreationApi {

    @POST(value = "/loans")
    suspend fun createLoan(
        @Body creationRequest: CreationRequest,
        @Header("Authorization") token: String
    ): CreationDTO

    @GET(value = "/loans/conditions")
    suspend fun getConditions(
        @Header("Authorization") token: String
    ): ConditionsDTO



}