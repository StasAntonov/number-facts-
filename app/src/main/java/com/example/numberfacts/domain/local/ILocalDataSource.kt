package com.example.numberfacts.domain.local

import androidx.paging.PagingSource
import com.example.numberfacts.data.datasource.local.entities.NumberEntity

interface ILocalDataSource {
    fun getAllLocalFacts(): PagingSource<Int, NumberEntity>

    suspend fun addLocalFact(fact: NumberEntity)
}