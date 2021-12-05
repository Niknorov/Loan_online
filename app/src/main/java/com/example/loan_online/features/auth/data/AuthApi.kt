package com.example.loan_online.features.auth.data

import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApi {

    @POST(value = "/login")
    suspend fun loginIntoApp(@Body authRequest: AuthRequest)

    @POST(value = "/registration")
    suspend fun registerInApp(@Body authRequest: AuthRequest): RegistrationDTO
}

