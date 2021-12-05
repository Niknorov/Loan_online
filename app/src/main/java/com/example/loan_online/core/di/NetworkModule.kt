package com.example.loan_online.core.di

import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor


val networkModule = module {
    single { provideOkHttpClient() }
    single { provideRetrofit(get()) }

}

fun provideRetrofit(
    okHttpClient: OkHttpClient
): Retrofit {
    return Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .baseUrl("focusstart.appspot.com")
        .build()
}

fun provideOkHttpClient(): OkHttpClient {

    val httpBuilder = OkHttpClient.Builder()
    val httpLoggingInterceptor = HttpLoggingInterceptor()
    httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
    return httpBuilder.addInterceptor(httpLoggingInterceptor)
        .build()

}