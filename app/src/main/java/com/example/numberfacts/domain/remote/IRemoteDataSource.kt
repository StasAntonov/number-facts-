package com.example.numberfacts.domain.remote

import com.example.numberfacts.data.base.ApiResponse

interface IRemoteDataSource {

    suspend fun getNumberFact(number: Long): ApiResponse<String>

    suspend fun getRandomNumberFact(): ApiResponse<String>
}