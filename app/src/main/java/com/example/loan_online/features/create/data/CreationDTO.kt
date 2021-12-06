package com.example.loan_online.features.create.data

data class CreationDTO(

    val amount: Number,
    val date: String,
    val firstName: String,
    val id: Int,
    val lastName: String,
    val percent: Number,
    val period: Int,
    val phoneNumber: String,
    val state: String,
)
