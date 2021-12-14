package com.example.loan_online.features.create.presentation

import com.example.loan_online.features.create.domain.ConditionsModel

sealed class CreateLoanUiState

object CreateLoanErrorNetwork : CreateLoanUiState()

class LoanConditionsUiState(val model: ConditionsModel) : CreateLoanUiState()


