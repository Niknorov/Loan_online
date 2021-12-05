package com.example.loan_online.core.di

import android.content.Context
import androidx.room.Room
import com.example.loan_online.core.AppDataBase
import org.koin.dsl.module

val databaseModule = module {

    single { provideDataBase(get()) }

}

private fun provideDataBase(context: Context) =
    Room.databaseBuilder(context, AppDataBase::class.java, "loan_database").build()