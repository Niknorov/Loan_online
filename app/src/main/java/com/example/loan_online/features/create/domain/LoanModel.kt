package com.example.loan_online.features.create.domain

data class LoanModel(
    val amount: Number,
    val date: String,
    val firstName: String,
    val id: Int,
    val lastName: String,
    val percent: Number,
    val period: Int,
    val phoneNumber: String,
    val state: LoanState,

    )

enum class LoanState {
    APPROVED, REGISTERED, REJECTED
}