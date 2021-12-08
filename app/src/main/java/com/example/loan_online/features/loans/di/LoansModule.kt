package com.example.loan_online.features.loans.di

import com.example.loan_online.features.loans.data.LoanRemoteDataSource
import com.example.loan_online.features.loans.data.LoanRepository
import com.example.loan_online.features.loans.data.LoansApi
import com.example.loan_online.features.loans.domain.GetLoansUseCase
import org.koin.dsl.module
import retrofit2.Retrofit

val loansModule = module {
    single { createLoansApi(get()) }
    single { LoanRemoteDataSource(get()) }
    single { LoanRepository(get(), get()) }
    single { GetLoansUseCase(get()) }
}

fun createLoansApi(retrofit: Retrofit): LoansApi {

    return retrofit.create(LoansApi::class.java)
}