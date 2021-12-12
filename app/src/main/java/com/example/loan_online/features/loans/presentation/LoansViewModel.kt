package com.example.loan_online.features.loans.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.loan_online.features.loans.domain.GetLoanDataUseCase
import com.example.loan_online.features.loans.domain.GetLoansUseCase
import kotlinx.coroutines.launch
import java.net.SocketTimeoutException
import java.net.UnknownHostException

class LoansViewModel(
    private val getLoansUseCase: GetLoansUseCase,
    private val getLoanDataUseCase: GetLoanDataUseCase
) : ViewModel() {

    private val _loansLiveData = MutableLiveData<LoansUiState>()
    val loansLiveData: LiveData<LoansUiState> = _loansLiveData

    private val _loanDataLiveData = MutableLiveData<LoanDataUiState>()
    val loanDataLiveData: LiveData<LoanDataUiState> = _loanDataLiveData

    fun getLoans() {
        viewModelScope.launch {
            try {
                _loansLiveData.postValue(SuccessLoansState(getLoansUseCase()))
            } catch (unknownHostException: UnknownHostException) {
                _loansLiveData.postValue(LoansErrorNetwork)
            } catch (socketTimeoutException: SocketTimeoutException) {
                _loansLiveData.postValue(LoansErrorNetwork)
            }

        }
    }

    fun getLoanData(id: Int) {
        viewModelScope.launch {
            try {
                _loanDataLiveData.postValue(SuccessLoanDataState(getLoanDataUseCase(id)))
            } catch (unknownHostException: UnknownHostException) {
                _loanDataLiveData.postValue(LoansDataErrorNetwork)
            } catch (socketTimeoutException: SocketTimeoutException) {
                _loanDataLiveData.postValue(LoansDataErrorNetwork)
            }

        }
    }
}