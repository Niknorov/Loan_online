package com.example.loan_online.features.create.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.loan_online.features.create.domain.GetConditionsUseCase
import com.example.loan_online.features.create.domain.CreateLoanUseCase
import androidx.lifecycle.viewModelScope
import com.example.loan_online.features.create.domain.LoanModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import java.net.SocketTimeoutException
import java.net.UnknownHostException

class CreationViewModel(
    private val createLoanUseCase: CreateLoanUseCase,
    private val getConditionsUseCase: GetConditionsUseCase,
) : ViewModel() {

    private val _conditionsLiveData = MutableLiveData<CreateLoanUiState>()
    val conditionsLiveData: LiveData<CreateLoanUiState> = _conditionsLiveData

    private val _loanLiveData = MutableLiveData<LoanModel>()
    val loanLiveData: LiveData<LoanModel> = _loanLiveData

    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        handleLoadingError(throwable)
    }

    fun getConditions() {
        viewModelScope.launch(exceptionHandler) {
            try {
                _conditionsLiveData.postValue(LoanConditionsUiState(getConditionsUseCase()))
            } catch (unknownHostException: UnknownHostException) {
                _conditionsLiveData.postValue(CreateLoanErrorNetwork)
            } catch (socketTimeoutException: SocketTimeoutException) {
                _conditionsLiveData.postValue(CreateLoanErrorNetwork)
            }

        }
    }

    fun getLoan(amount: Double, firstName: String, lastName: String, phoneNumber: String) {
        viewModelScope.launch(exceptionHandler) {
            if (_conditionsLiveData.value is LoanConditionsUiState) {

                val loanCreateLoanUiState = _conditionsLiveData.value as LoanConditionsUiState

                _loanLiveData.postValue(

                    createLoanUseCase(
                        amount = amount, firstName = firstName,
                        lastName = lastName, phoneNumber = phoneNumber,
                        percent = loanCreateLoanUiState.model.percent,
                        period = loanCreateLoanUiState.model.period

                    )!!
                )

            }
        }
    }

    private fun handleLoadingError(error: Throwable) {
        Log.e("LoansViewModel", "Failed to load loan", error)
    }

}