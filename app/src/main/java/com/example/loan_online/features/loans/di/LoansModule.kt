package com.example.loan_online.features.loans.di

import com.example.loan_online.features.loans.data.LoanRemoteDataSource
import com.example.loan_online.features.loans.data.LoanRepository
import com.example.loan_online.features.loans.data.LoansApi
import com.example.loan_online.features.loans.domain.GetLoanDataUseCase
import com.example.loan_online.features.loans.domain.GetLoansUseCase
import com.example.loan_online.features.loans.presentation.LoansViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val loansModule = module {
    single { createLoansApi(get()) }
    single { LoanRemoteDataSource(get()) }
    single { LoanRepository(get(), get()) }
    single { GetLoansUseCase(get()) }
    single { GetLoanDataUseCase(get()) }
    viewModel { LoansViewModel(get(), get()) }
}

fun createLoansApi(retrofit: Retrofit): LoansApi {

    return retrofit.create(LoansApi::class.java)
}