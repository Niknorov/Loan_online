package com.example.loan_online.features.loans.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.loan_online.features.create.domain.LoanModel
import com.example.loan_online.features.loans.domain.GetLoansUseCase
import kotlinx.coroutines.launch

class LoansViewModel(
    private val getLoansUseCase: GetLoansUseCase
) : ViewModel() {

    private val _loansLiveData = MutableLiveData<List<LoanModel>>()
    val loansLiveData: LiveData<List<LoanModel>> = _loansLiveData


    fun getLoans() {
        viewModelScope.launch {

            _loansLiveData.postValue(getLoansUseCase()!!)
        }
    }
}