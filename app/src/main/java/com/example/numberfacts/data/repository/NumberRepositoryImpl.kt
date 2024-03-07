package com.example.numberfacts.data.repository

import androidx.paging.PagingSource
import com.example.numberfacts.data.base.ApiResponse
import com.example.numberfacts.data.datasource.local.entities.NumberEntity
import com.example.numberfacts.domain.local.ILocalDataSource
import com.example.numberfacts.domain.model.NumberFact
import com.example.numberfacts.domain.model.toNumberEntity
import com.example.numberfacts.domain.remote.IRemoteDataSource
import com.example.numberfacts.domain.repository.INumberRepository
import com.example.numberfacts.ext.toLong
import javax.inject.Inject

class NumberRepositoryImpl @Inject constructor(
    private val remoteDataSource: IRemoteDataSource,
    private val localDataSource: ILocalDataSource
): INumberRepository {
    override suspend fun getNumberFact(number: Long): ApiResponse<String> {
        return remoteDataSource.getNumberFact(number).handleFactSave(number)
    }

    override suspend fun getRandomNumberFact(): ApiResponse<String> {
        return remoteDataSource.getRandomNumberFact().handleFactSave(null)

    }

    override fun getAllLocalFacts(): PagingSource<Int, NumberEntity> {
        return localDataSource.getAllLocalFacts()
    }

    override suspend fun addLocalFact(fact: NumberFact) {
        localDataSource.addLocalFact(fact.toNumberEntity())
    }

    private suspend fun ApiResponse<String>.handleFactSave(number: Long?): ApiResponse<String>{
        when (this){
            is ApiResponse.Success -> {
                addLocalFact(NumberFact(this.data,number ?: this.data.toLong()))
            }
            is ApiResponse.Error -> {

            }
        }
        return this
    }

}