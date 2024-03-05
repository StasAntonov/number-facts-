package com.example.numberfacts.data.datasource.remote

import com.example.numberfacts.data.base.ApiResponse
import com.example.numberfacts.data.base.BaseDataSource
import com.example.numberfacts.data.datasource.remote.network.NumbersApi
import com.example.numberfacts.domain.remote.IRemoteDataSource
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val numbersApi: NumbersApi
): BaseDataSource(), IRemoteDataSource {

    override suspend fun getNumberFact(number: Long): ApiResponse<String>{
        return request { numbersApi.getNumberFact(number) }
    }

    override suspend fun getRandomNumberFact(): ApiResponse<String> {
        return request { numbersApi.getRandomNumberFact() }
    }
}