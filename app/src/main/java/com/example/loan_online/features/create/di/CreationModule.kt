package com.example.loan_online.features.create.di

import com.example.loan_online.features.create.data.CreationApi
import com.example.loan_online.features.create.data.CreationRemoteDataSource
import com.example.loan_online.features.create.data.CreationRepository
import com.example.loan_online.features.create.domain.PerformCreationUseCase
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.create

val creationModule = module {
    single { createCreationApi(get()) }
    single { CreationRemoteDataSource(get()) }
    single { CreationRepository(get(), get()) }
    single { PerformCreationUseCase(get()) }
    //viewModel{...}
}

fun createCreationApi(retrofit: Retrofit): CreationApi {

    return retrofit.create(CreationApi::class.java)
}