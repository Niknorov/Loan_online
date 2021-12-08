package com.example.loan_online.core

import android.app.Application
import com.example.loan_online.core.di.databaseModule
import com.example.loan_online.core.di.networkModule
import com.example.loan_online.features.auth.di.authModule
import com.example.loan_online.features.create.di.creationModule
import com.example.loan_online.features.loans.di.loansModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(
                databaseModule,
                networkModule,
                authModule,
                creationModule,
                loansModule,
            )
        }
    }
}