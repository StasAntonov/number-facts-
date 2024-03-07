package com.example.numberfacts.domain.repository

import androidx.paging.PagingSource
import com.example.numberfacts.data.base.ApiResponse
import com.example.numberfacts.data.datasource.local.entities.NumberEntity
import com.example.numberfacts.domain.model.NumberFact

interface INumberRepository {

    suspend fun getNumberFact(number: Long): ApiResponse<String>

    suspend fun getRandomNumberFact(): ApiResponse<String>

    fun getAllLocalFacts(): PagingSource<Int, NumberEntity>

    suspend fun addLocalFact(fact: NumberFact)
}