package com.example.loan_online.features.create.domain

class GetConditionsUseCase(
    private val creationRepository: CreationRepository
) {

    suspend operator fun invoke(): ConditionsModel {

        return creationRepository.getConditions()
    }

}