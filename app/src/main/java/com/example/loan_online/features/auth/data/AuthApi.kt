package com.example.loan_online.features.auth.data

import okhttp3.ResponseBody
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApi {

    @POST(value = "/login")
    suspend fun loginIntoApp(@Body authRequest: AuthRequest): ResponseBody

    @POST(value = "/registration")
    suspend fun registerInApp(@Body authRequest: AuthRequest): RegistrationDTO
}

