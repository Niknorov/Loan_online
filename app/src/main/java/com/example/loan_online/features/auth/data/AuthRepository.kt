package com.example.loan_online.features.auth.data

class AuthRepository(
    private val authRemoteDataSource: AuthRemoteDataSource

) {

    suspend fun performAuth(login: String, password: String) {
        authRemoteDataSource.performAuth(AuthRequest(login, password))
    }


    suspend fun performRegistration(login: String, password: String) {
        authRemoteDataSource.performRegistration(AuthRequest(login, password))
    }
}