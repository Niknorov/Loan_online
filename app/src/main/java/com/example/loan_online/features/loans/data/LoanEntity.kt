package com.example.loan_online.features.loans.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class LoanEntity(

    @PrimaryKey
    var amount: Number,
    var date: String,
    var firstName: String,
    var id: Int,
    var lastName: String,
    var percent: Number,
    var period: Int,
    var phoneNumber: String,
    var state: String,

    )


