package com.example.loan_online.features.loans.domain.models

data class LoanRequestModel(
    val amount: Int,
    val firstName: String,
    val lastName: String,
    val percent: Number,
    val period: Int,
    val phoneNumber: String,
)
