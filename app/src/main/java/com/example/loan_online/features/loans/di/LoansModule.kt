package com.example.loan_online.features.loans.di

import com.example.loan_online.core.AppDataBase
import com.example.loan_online.features.loans.data.*
import com.example.loan_online.features.loans.domain.ClearTokenUseCase
import com.example.loan_online.features.loans.domain.GetLoanDataUseCase
import com.example.loan_online.features.loans.domain.GetLoansUseCase
import com.example.loan_online.features.loans.presentation.LoansViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val loansModule = module {
    single { createLoansApi(get()) }
    single { createLoanDao(get()) }
    single { LoanRemoteDataSource(get()) }
    single { LoanLocalDataSource(get()) }
    single { LoanRepository(get(), get(), get()) }
    single { GetLoansUseCase(get()) }
    single { GetLoanDataUseCase(get()) }
    single { ClearTokenUseCase(get()) }
    viewModel { LoansViewModel(get(), get(), get()) }
}

fun createLoansApi(retrofit: Retrofit): LoansApi {

    return retrofit.create(LoansApi::class.java)
}

fun createLoanDao(dataBase: AppDataBase): LoanDao {

    return dataBase.createLoanDao()
}