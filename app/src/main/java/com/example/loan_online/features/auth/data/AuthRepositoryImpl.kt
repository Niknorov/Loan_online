package com.example.loan_online.features.auth.data

import com.example.loan_online.features.auth.domain.repository.AuthRepository

class AuthRepositoryImpl(
    private val authRemoteDataSource: AuthRemoteDataSource,
    private val tokenLocalDataSource: TokenLocalDataSource
) : AuthRepository {

    override suspend fun performAuth(login: String, password: String) {
        val token = authRemoteDataSource.performAuth(AuthRequest(login, password))
        tokenLocalDataSource.setToken(token)

    }

    override suspend fun performRegistration(login: String, password: String) {
        authRemoteDataSource.performRegistration(AuthRequest(login, password))
        performAuth(login, password)
    }
}