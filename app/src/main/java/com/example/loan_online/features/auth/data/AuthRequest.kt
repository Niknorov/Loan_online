package com.example.loan_online.features.auth.data

import com.google.gson.annotations.SerializedName

data class AuthRequest(

    @SerializedName("name") val name: String,
    @SerializedName ("password")val password: String
)
