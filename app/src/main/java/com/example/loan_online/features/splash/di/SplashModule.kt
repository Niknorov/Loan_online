package com.example.loan_online.features.splash.di

import com.example.loan_online.features.auth.domain.usecase.GetTokenUseCase
import com.example.loan_online.features.splash.presentation.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val splashModule = module {
    single { GetTokenUseCase(get()) }
    viewModel { SplashViewModel(get()) }
}

