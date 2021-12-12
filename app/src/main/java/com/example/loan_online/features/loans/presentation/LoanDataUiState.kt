package com.example.loan_online.features.loans.presentation

import com.example.loan_online.features.create.domain.LoanModel

sealed class LoanDataUiState

object LoansDataErrorNetwork : LoanDataUiState()

class SuccessLoanDataState(val model: LoanModel) : LoanDataUiState()
