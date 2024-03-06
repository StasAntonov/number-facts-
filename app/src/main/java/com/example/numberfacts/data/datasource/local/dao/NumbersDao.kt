package com.example.numberfacts.data.datasource.local.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.numberfacts.data.datasource.local.entities.NumberEntity

@Dao
interface NumbersDao {
    @Query("SELECT * FROM facts")
    fun getAllFacts(): PagingSource<Int, NumberEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFact(fact: NumberEntity)
}