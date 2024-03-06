package com.example.numberfacts.data.datasource.local

import androidx.paging.PagingSource
import com.example.numberfacts.data.datasource.local.dao.NumbersDao
import com.example.numberfacts.data.datasource.local.entities.NumberEntity
import com.example.numberfacts.domain.local.ILocalDataSource
import javax.inject.Inject

class LocalDataSource @Inject constructor(
    private val numbersDao: NumbersDao
): ILocalDataSource {
    override fun getAllLocalFacts(): PagingSource<Int, NumberEntity> =
        numbersDao.getAllFacts()

    override suspend fun addLocalFact(fact: NumberEntity) {
        numbersDao.insertFact(fact)
    }
}