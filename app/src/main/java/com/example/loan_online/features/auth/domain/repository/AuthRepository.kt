package com.example.loan_online.features.auth.domain.repository

interface AuthRepository {

    suspend fun performAuth(login: String, password: String)

    suspend fun performRegistration(login: String, password: String)
}