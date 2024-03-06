package com.example.numberfacts.data.repository

import androidx.paging.PagingSource
import com.example.numberfacts.data.base.ApiResponse
import com.example.numberfacts.data.datasource.local.entities.NumberEntity
import com.example.numberfacts.domain.local.ILocalDataSource
import com.example.numberfacts.domain.model.NumberFact
import com.example.numberfacts.domain.model.toNumberEntity
import com.example.numberfacts.domain.remote.IRemoteDataSource
import com.example.numberfacts.domain.repository.INumberRepository
import javax.inject.Inject

class NumberRepositoryImpl @Inject constructor(
    private val remoteDataSource: IRemoteDataSource,
    private val localDataSource: ILocalDataSource
): INumberRepository {
    override suspend fun getNumberFact(number: Long): ApiResponse<String> {
        remoteDataSource.getNumberFact(number).let {
            when (it) {
                is ApiResponse.Success -> {
                    addLocalFact(NumberFact(it.data,number))
                }
                else -> {}
            }
            return it
        }
    }

    override suspend fun getRandomNumberFact(): ApiResponse<String> {
        return remoteDataSource.getRandomNumberFact()
    }

    override fun getAllLocalFacts(): PagingSource<Int, NumberEntity> {
        return localDataSource.getAllLocalFacts() // todo Number
//        return localDataSource.getAllLocalFacts().map {
//            it.toNumberFact()
//        }
    }

    override suspend fun addLocalFact(fact: NumberFact) {
        localDataSource.addLocalFact(fact.toNumberEntity())
    }
}