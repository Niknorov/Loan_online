package com.example.loan_online.features.create.data

import com.google.gson.annotations.SerializedName

data class ConditionsDTO(

    @SerializedName("maxAmount") val maxAmount: Double,
    @SerializedName("percent") val percent: Double,
    @SerializedName("period") val period: Int
)
