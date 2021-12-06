package com.example.loan_online.features.create.data

import com.google.gson.annotations.SerializedName

data class ConditionsDTO(

    @SerializedName("maxAmount") val maxAmount: Int,
    @SerializedName("percent") val percent: Int,
    @SerializedName("period") val period: Int
)
