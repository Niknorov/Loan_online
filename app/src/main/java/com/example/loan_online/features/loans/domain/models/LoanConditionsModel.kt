package com.example.loan_online.features.loans.domain.models

data class LoanConditionsModel(
    val maxAmount: Number,
    val percent: Number,
    val period: Int
)
