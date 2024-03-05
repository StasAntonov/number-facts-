package com.example.numberfacts.domain.repository

import com.example.numberfacts.data.base.ApiResponse

interface INumberRepository {

    suspend fun getNumberFact(number: Long): ApiResponse<String>

    suspend fun getRandomNumberFact(): ApiResponse<String>
}