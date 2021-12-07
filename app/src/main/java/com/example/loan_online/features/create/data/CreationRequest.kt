package com.example.loan_online.features.create.data

import com.example.loan_online.features.create.domain.LoanState
import com.google.gson.annotations.SerializedName

data class CreationRequest
    (
    @SerializedName("amount") val amount: Double,
    @SerializedName("firstName") val firstName: String,
    @SerializedName("lastName") val lastName: String,
    @SerializedName("percent") val percent: Double,
    @SerializedName("period") val period: Int,
    @SerializedName("phoneNumber") val phoneNumber: String,

    )


