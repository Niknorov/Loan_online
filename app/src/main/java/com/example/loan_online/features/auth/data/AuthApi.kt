package com.example.loan_online.features.auth.data

import retrofit2.http.POST

interface AuthApi {

    @POST(value = "/login")
    suspend fun loginIntoApp(authRequest: AuthRequest): String

    @POST(value = "/registration")
    suspend fun registerInApp(authRequest: AuthRequest): RegistrationDTO
}

