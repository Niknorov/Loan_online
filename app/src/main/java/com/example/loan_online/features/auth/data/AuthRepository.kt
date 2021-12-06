package com.example.loan_online.features.auth.data

class AuthRepository(
    private val authRemoteDataSource: AuthRemoteDataSource,
    private val tokenLocalDataSource: TokenLocalDataSource
) {

    suspend fun performAuth(login: String, password: String) {
        val token = authRemoteDataSource.performAuth(AuthRequest(login, password))
        tokenLocalDataSource.setToken(token)

    }


    suspend fun performRegistration(login: String, password: String) {
        authRemoteDataSource.performRegistration(AuthRequest(login, password))
        performAuth(login, password)
    }
}