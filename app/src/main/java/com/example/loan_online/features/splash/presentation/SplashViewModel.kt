package com.example.loan_online.features.splash.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.loan_online.features.auth.domain.usecase.GetTokenUseCase

class SplashViewModel(
    private val getTokenUseCase: GetTokenUseCase
) : ViewModel() {

    private val _splashLiveData = MutableLiveData<SplashState>()
    val splashLiveData: LiveData<SplashState> = _splashLiveData

    fun startTransition() {
        val token = getTokenUseCase()
        if (token.isBlank()) {
            _splashLiveData.postValue(SplashState.GOTOLOGIN)
        } else {
            _splashLiveData.postValue(SplashState.GOTOLOANS)
        }
    }
}