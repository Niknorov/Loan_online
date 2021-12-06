package com.example.loan_online.features.create.domain

import com.example.loan_online.features.create.data.CreationRepository

class GetConditionsUseCase(
    private val creationRepository: CreationRepository
) {

    suspend operator fun invoke(): ConditionsModel {

        return creationRepository.getConditions()
    }

}