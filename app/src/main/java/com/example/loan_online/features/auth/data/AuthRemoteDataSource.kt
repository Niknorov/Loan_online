package com.example.loan_online.features.auth.data

class AuthRemoteDataSource(
    private val authApi: AuthApi,
) {
    suspend fun performAuth(authRequest: AuthRequest): String {

        return authApi.loginIntoApp(authRequest).string()
    }

    suspend fun performRegistration(authRequest: AuthRequest): RegistrationDTO {

        return authApi.registerInApp(authRequest)
    }
}
