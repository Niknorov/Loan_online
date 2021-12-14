package com.example.loan_online.features.loans.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class LoanEntity(

    @PrimaryKey
    var id: Int,
    var amount: Double,
    var date: String,
    var firstName: String,
    var lastName: String,
    var percent: Double,
    var period: Int,
    var phoneNumber: String,
    var state: String,
)


