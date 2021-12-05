package com.example.loan_online.features.create.data

import com.example.loan_online.features.create.domain.LoanState
import com.google.gson.annotations.SerializedName

data class CreationRequest
    (
    @SerializedName("amount") val amount: Number,
    @SerializedName("date") val date: String,
    @SerializedName("firstName") val firstName: String,
    @SerializedName("id") val id: Int,
    @SerializedName("lastName") val lastName: String,
    @SerializedName("percent") val percent: Number,
    @SerializedName("period") val period: Int,
    @SerializedName("phoneNumber") val phoneNumber: String,
    @SerializedName("state") val state: LoanState,

    )

/*enum class LoanState {
    APPROVED, REGISTERED, REJECTED
}*/
