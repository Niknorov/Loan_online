package com.example.loan_online.features.create.di

import com.example.loan_online.features.create.data.CreationApi
import com.example.loan_online.features.create.data.CreationRemoteDataSource
import com.example.loan_online.features.create.data.CreationRepository
import com.example.loan_online.features.create.domain.GetConditionsUseCase
import com.example.loan_online.features.create.domain.PerformCreationUseCase
import com.example.loan_online.features.create.presentation.CreationViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.create

val creationModule = module {
    single { createCreationApi(get()) }
    single { CreationRemoteDataSource(get()) }
    single { CreationRepository(get(), get()) }
    single { PerformCreationUseCase(get()) }
    single { GetConditionsUseCase(get()) }
    viewModel { CreationViewModel(get(), get()) }

}

fun createCreationApi(retrofit: Retrofit): CreationApi {

    return retrofit.create(CreationApi::class.java)
}