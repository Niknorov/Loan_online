package com.example.loan_online.features.create.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.loan_online.features.create.domain.ConditionsModel
import com.example.loan_online.features.create.domain.GetConditionsUseCase
import com.example.loan_online.features.create.domain.PerformCreationUseCase
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class CreationViewModel(
    private val performCreationUseCase: PerformCreationUseCase,
    private val getConditionsUseCase: GetConditionsUseCase,
) : ViewModel() {

    private val _conditionsLiveData = MutableLiveData<ConditionsModel>()
    val conditionsLiveData: LiveData<ConditionsModel> = _conditionsLiveData

    fun getConditions() {
        viewModelScope.launch {

            _conditionsLiveData.postValue(getConditionsUseCase()!!)
        }
    }
}