package com.example.loan_online.features.auth.data

import com.google.gson.annotations.SerializedName

data class AuthRequest(

    @SerializedName("Name") val name: String,
    @SerializedName ("Password")val password: String
)
