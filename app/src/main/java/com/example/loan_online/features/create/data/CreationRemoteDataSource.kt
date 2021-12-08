package com.example.loan_online.features.create.data

class CreationRemoteDataSource(
    private val creationApi: CreationApi
) {
    suspend fun createLoan(creationRequest: CreationRequest, token: String): CreationDTO {

        return creationApi.createLoan(creationRequest, token)
    }

    suspend fun getConditions(token: String): ConditionsDTO {

        return creationApi.getConditions(token)
    }

}