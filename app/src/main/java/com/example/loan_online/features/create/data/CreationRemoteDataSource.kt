package com.example.loan_online.features.create.data

class CreationRemoteDataSource(
    private val creationApi: CreationApi,
) {
    suspend fun performCreation(creationRequest: CreationRequest): CreationDTO {

        return creationApi.createLoan(creationRequest)
    }
}