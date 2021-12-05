package com.example.loan_online.features.create.data

import retrofit2.http.Body
import retrofit2.http.POST

interface CreationApi {

    @POST(value = "/loans")
    suspend fun createLoan(@Body creationRequest: CreationRequest): CreationDTO
}