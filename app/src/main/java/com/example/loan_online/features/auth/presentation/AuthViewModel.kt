package com.example.loan_online.features.auth.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.loan_online.features.auth.domain.usecase.PerformAuthUseCase
import com.example.loan_online.features.auth.domain.usecase.PerformRegistrationUseCase
import kotlinx.coroutines.launch
import retrofit2.HttpException

class AuthViewModel(
    private val performAuthUseCase: PerformAuthUseCase,
    private val performRegistrationUseCase: PerformRegistrationUseCase
) : ViewModel() {

    private val _uIStateLiveData = MutableLiveData<LoginUiState>()
    val uISateLivedata: LiveData<LoginUiState> = _uIStateLiveData


    fun launchAuth(login: String, password: String) {
        if (login.isNotBlank() && password.isNotBlank()) {
            viewModelScope.launch {
                try {
                    _uIStateLiveData.postValue(LoginUiState.PROGRESS)

                    performAuthUseCase(login, password)

                    _uIStateLiveData.postValue(LoginUiState.SUCCESS)

                } catch (e: HttpException) {
                    if (e.code() == 404) {
                        _uIStateLiveData.postValue(LoginUiState.ERROR_INVALID_CREDENCE)
                    }
                }
            }
        } else {
            _uIStateLiveData.postValue(LoginUiState.ERROR_EMPTY_INPUT)
        }
    }

    fun launchRegistration(login: String, password: String) {
        if (login.isNotBlank() && password.isNotBlank()) {
            viewModelScope.launch {
                try {
                    _uIStateLiveData.postValue(LoginUiState.PROGRESS)

                    performRegistrationUseCase(login, password)

                    _uIStateLiveData.postValue(LoginUiState.SUCCESS)
                } catch (e: HttpException) {
                    if (e.code() == 400) {
                        _uIStateLiveData.postValue(LoginUiState.ERROR_USER_EXIST)
                    }

                }

            }
        } else {
            _uIStateLiveData.postValue(LoginUiState.ERROR_EMPTY_INPUT)
        }
    }
}