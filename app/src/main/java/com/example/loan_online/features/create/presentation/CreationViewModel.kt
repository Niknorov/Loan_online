package com.example.loan_online.features.create.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.loan_online.features.create.domain.ConditionsModel
import com.example.loan_online.features.create.domain.GetConditionsUseCase
import com.example.loan_online.features.create.domain.CreateLoanUseCase
import androidx.lifecycle.viewModelScope
import com.example.loan_online.features.create.domain.LoanModel
import kotlinx.coroutines.launch

class CreationViewModel(
    private val createLoanUseCase: CreateLoanUseCase,
    private val getConditionsUseCase: GetConditionsUseCase,
) : ViewModel() {

    private val _conditionsLiveData = MutableLiveData<ConditionsModel>()
    val conditionsLiveData: LiveData<ConditionsModel> = _conditionsLiveData

    private val _loanLiveData = MutableLiveData<LoanModel>()
    val loanLiveData: LiveData<LoanModel> = _loanLiveData

    fun getConditions() {
        viewModelScope.launch {

            _conditionsLiveData.postValue(getConditionsUseCase()!!)
        }
    }

    fun getLoan(amount: Double, firstName: String, lastName: String, phoneNumber: String) {
        viewModelScope.launch {

            _loanLiveData.postValue(
                createLoanUseCase(
                    amount = amount, firstName = firstName,
                    lastName = lastName, phoneNumber = phoneNumber,
                    percent = _conditionsLiveData.value!!.percent,
                    period = _conditionsLiveData.value!!.period
                )!!
            )
        }
    }

}