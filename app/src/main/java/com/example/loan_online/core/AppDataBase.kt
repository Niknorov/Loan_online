package com.example.loan_online.core

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.loan_online.features.loans.data.LoanDao
import com.example.loan_online.features.loans.data.LoanEntity

@Database(entities = [LoanEntity::class], version = 1)
abstract class AppDataBase: RoomDatabase() {

    abstract fun createLoanDao(): LoanDao


}