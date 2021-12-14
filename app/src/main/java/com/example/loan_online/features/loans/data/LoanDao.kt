package com.example.loan_online.features.loans.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface LoanDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertLoans(loansList: List<LoanEntity>)

    @Query("SELECT * FROM LoanEntity")
    fun getLoan(): List<LoanEntity>
}