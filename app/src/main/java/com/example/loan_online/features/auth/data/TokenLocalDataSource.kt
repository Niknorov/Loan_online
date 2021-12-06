package com.example.loan_online.features.auth.data

import android.content.Context
import androidx.core.content.edit

class TokenLocalDataSource(context: Context) {

    private val sharedPreferences = context.getSharedPreferences("token_pref", Context.MODE_PRIVATE)
    fun setToken(token: String) {
        sharedPreferences.edit {
            putString("token", token)
        }
    }

    fun getToken(): String {

        return sharedPreferences.getString("token", "").orEmpty()
    }
}