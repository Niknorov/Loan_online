package com.example.loan_online.features.auth.data

class AuthRemoteDataSource(
    private val authApi: AuthApi,
) {
    suspend fun performAuth(authRequest: AuthRequest) {

        authApi.loginIntoApp(authRequest)
    }

    suspend fun performRegistration(authRequest: AuthRequest): RegistrationDTO {

        return authApi.registerInApp(authRequest)
    }
}
