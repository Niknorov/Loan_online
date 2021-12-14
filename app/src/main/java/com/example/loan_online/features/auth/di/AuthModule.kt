package com.example.loan_online.features.auth.di

import com.example.loan_online.features.auth.data.*
import com.example.loan_online.features.auth.domain.repository.AuthRepository
import com.example.loan_online.features.auth.domain.repository.TokenRepository
import com.example.loan_online.features.auth.domain.usecase.PerformAuthUseCase
import com.example.loan_online.features.auth.domain.usecase.PerformRegistrationUseCase
import com.example.loan_online.features.auth.presentation.AuthViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val authModule = module {

    single { createAuthApi(get()) }
    single { AuthRemoteDataSource(get()) }
    single { TokenLocalDataSource(get()) }
    single<AuthRepository> { return@single AuthRepositoryImpl(get(), get()) }
    single<TokenRepository> { return@single TokenRepositoryImpl(get()) }
    single { PerformAuthUseCase(get()) }
    single { PerformRegistrationUseCase(get()) }
    viewModel { AuthViewModel(get(), get()) }
}

fun createAuthApi(retrofit: Retrofit): AuthApi {
    return retrofit.create(AuthApi::class.java)
}
