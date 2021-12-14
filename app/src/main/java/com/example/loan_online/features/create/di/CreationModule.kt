package com.example.loan_online.features.create.di

import com.example.loan_online.features.create.data.CreationApi
import com.example.loan_online.features.create.data.CreationRemoteDataSource
import com.example.loan_online.features.create.data.CreationRepositoryImpl
import com.example.loan_online.features.create.domain.GetConditionsUseCase
import com.example.loan_online.features.create.domain.CreateLoanUseCase
import com.example.loan_online.features.create.domain.CreationRepository
import com.example.loan_online.features.create.presentation.CreationViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val creationModule = module {
    single { createCreationApi(get()) }
    single { CreationRemoteDataSource(get()) }
    single<CreationRepository> { return@single CreationRepositoryImpl(get(), get()) }
    single { CreateLoanUseCase(get()) }
    single { GetConditionsUseCase(get()) }
    viewModel { CreationViewModel(get(), get()) }

}

fun createCreationApi(retrofit: Retrofit): CreationApi {

    return retrofit.create(CreationApi::class.java)
}