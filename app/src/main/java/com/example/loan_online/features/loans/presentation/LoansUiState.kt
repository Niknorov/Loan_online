package com.example.loan_online.features.loans.presentation

import com.example.loan_online.features.create.domain.LoanModel

sealed class LoansUiState

object LoansErrorNetwork : LoansUiState()


class SuccessLoansState(val models: List<LoanModel>) : LoansUiState()





