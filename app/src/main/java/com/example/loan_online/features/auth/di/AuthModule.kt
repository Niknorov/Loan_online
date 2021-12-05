package com.example.loan_online.features.auth.di

import com.example.loan_online.features.auth.data.AuthApi
import com.example.loan_online.features.auth.data.AuthRemoteDataSource
import com.example.loan_online.features.auth.data.AuthRepository
import com.example.loan_online.features.auth.domain.usecase.PerformAuthUseCase
import com.example.loan_online.features.auth.domain.usecase.PerformRegistrationUseCase
import com.example.loan_online.features.auth.presentation.AuthViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val authModule = module {

    single { createAuthApi(get()) }
    single { AuthRemoteDataSource(get()) }
    single { AuthRepository(get()) }
    single { PerformAuthUseCase(get()) }
    single { PerformRegistrationUseCase(get()) }
    viewModel { AuthViewModel(get(), get()) }
}

fun createAuthApi(retrofit: Retrofit): AuthApi {
    return retrofit.create(AuthApi::class.java)
}
