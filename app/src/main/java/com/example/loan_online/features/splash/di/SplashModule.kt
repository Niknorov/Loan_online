package com.example.loan_online.features.splash.di

import com.example.loan_online.features.splash.data.TokenRepository
import com.example.loan_online.features.splash.domain.GetTokenUseCase
import com.example.loan_online.features.splash.presentation.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val splashModule = module {
    single { TokenRepository(get()) }
    single { GetTokenUseCase(get()) }
    viewModel { SplashViewModel(get()) }
}

