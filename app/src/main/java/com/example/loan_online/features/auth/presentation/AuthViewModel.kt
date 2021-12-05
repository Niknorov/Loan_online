package com.example.loan_online.features.auth.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.loan_online.features.auth.data.AuthRequest
import com.example.loan_online.features.auth.domain.usecase.PerformAuthUseCase
import kotlinx.coroutines.launch

class AuthViewModel(
    private val performAuthUseCase: PerformAuthUseCase
) : ViewModel() {

    private val _liveData = MutableLiveData<LoginUiState>()
    val livedata: LiveData<LoginUiState> = _liveData


    fun launchAuth(login: String, password: String) {
        viewModelScope.launch {

            _liveData.postValue(LoginUiState.PROGRESS)

            performAuthUseCase(login, password)

            _liveData.postValue(LoginUiState.SUCCES)
        }
    }

}