package com.example.numberfacts.data.repository

import com.example.numberfacts.data.base.ApiResponse
import com.example.numberfacts.domain.remote.IRemoteDataSource
import com.example.numberfacts.domain.repository.INumberRepository
import javax.inject.Inject

class NumberRepositoryImpl @Inject constructor(
    private val remoteDataSource: IRemoteDataSource
): INumberRepository {
    override suspend fun getNumberFact(number: Long): ApiResponse<String> {
        return remoteDataSource.getNumberFact(number)
    }

    override suspend fun getRandomNumberFact(): ApiResponse<String> {
        return remoteDataSource.getRandomNumberFact()
    }
}