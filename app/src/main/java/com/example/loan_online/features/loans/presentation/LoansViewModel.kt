package com.example.loan_online.features.loans.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.loan_online.features.create.domain.LoanModel
import com.example.loan_online.features.loans.domain.GetLoanDataUseCase
import com.example.loan_online.features.loans.domain.GetLoansUseCase
import kotlinx.coroutines.launch

class LoansViewModel(
    private val getLoansUseCase: GetLoansUseCase,
    private val getLoanDataUseCase: GetLoanDataUseCase
) : ViewModel() {

    private val _loansLiveData = MutableLiveData<List<LoanModel>>()
    val loansLiveData: LiveData<List<LoanModel>> = _loansLiveData

    private val _loanDataLiveData = MutableLiveData<LoanModel>()
    val loanDataLiveData: LiveData<LoanModel> = _loanDataLiveData

    fun getLoans() {
        viewModelScope.launch {

            _loansLiveData.postValue(getLoansUseCase()!!)
        }
    }

    fun getLoanData(id: Int) {
        viewModelScope.launch {

            _loanDataLiveData.postValue(getLoanDataUseCase(id)!!)
        }
    }
}