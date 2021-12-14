package com.example.loan_online.features.loans.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.loan_online.features.loans.domain.ClearTokenUseCase
import com.example.loan_online.features.loans.domain.GetLoanDataUseCase
import com.example.loan_online.features.loans.domain.GetLoansUseCase
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.net.SocketTimeoutException
import java.net.UnknownHostException

class LoansViewModel(
    private val getLoansUseCase: GetLoansUseCase,
    private val getLoanDataUseCase: GetLoanDataUseCase,
    private val clearTokenUseCase: ClearTokenUseCase
) : ViewModel() {

    private val _loansLiveData = MutableLiveData<LoansUiState>()
    val loansLiveData: LiveData<LoansUiState> = _loansLiveData

    private val _loanDataLiveData = MutableLiveData<LoanDataUiState>()
    val loanDataLiveData: LiveData<LoanDataUiState> = _loanDataLiveData

    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        handleLoadingError(throwable)
    }

    fun getLoans() {
        viewModelScope.launch(exceptionHandler) {
            try {
                withContext(Dispatchers.IO) {
                    _loansLiveData.postValue(SuccessLoansState(getLoansUseCase()))

                }
            } catch (unknownHostException: UnknownHostException) {
                _loansLiveData.postValue(LoansErrorNetwork)
            } catch (socketTimeoutException: SocketTimeoutException) {
                _loansLiveData.postValue(LoansErrorNetwork)
            }

        }
    }

    fun getLoanData(id: Int) {
        viewModelScope.launch(exceptionHandler) {
            try {
                _loanDataLiveData.postValue(SuccessLoanDataState(getLoanDataUseCase(id)))
            } catch (unknownHostException: UnknownHostException) {
                _loanDataLiveData.postValue(LoansDataErrorNetwork)
            } catch (socketTimeoutException: SocketTimeoutException) {
                _loanDataLiveData.postValue(LoansDataErrorNetwork)
            }

        }
    }

    fun onExit() {
        clearTokenUseCase()
    }

    private fun handleLoadingError(error: Throwable) {
        Log.e("LoansViewModel", "Failed to load loan", error)
    }

}