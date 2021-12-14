package com.example.loan_online.features.auth.domain.repository

interface TokenRepository {

    fun getToken(): String

    fun clearToken()
}