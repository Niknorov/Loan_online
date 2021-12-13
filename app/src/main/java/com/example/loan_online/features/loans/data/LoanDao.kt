package com.example.loan_online.features.loans.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.loan_online.features.create.domain.LoanModel

@Dao
interface LoanDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLoans(loansList: List<LoanEntity>)

    @Query("SELECT * FROM LoanEntity")
    suspend fun getLoan(): List<LoanEntity>
}