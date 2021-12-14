package com.example.loan_online.features.loans.data

data class LoanDTO(

    val id: Int,
    val amount: Double,
    val date: String,
    val firstName: String,
    val lastName: String,
    val percent: Double,
    val period: Int,
    val phoneNumber: String,
    val state: String,
)
