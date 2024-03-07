package com.example.numberfacts.data.datasource.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.numberfacts.data.datasource.local.dao.NumbersDao
import com.example.numberfacts.data.datasource.local.entities.NumberEntity

@Database(entities = [NumberEntity::class], version = AppDataBase.DB_VERSION)
abstract class AppDataBase: RoomDatabase() {
    abstract fun numbersDao(): NumbersDao

    companion object {
        const val DB_VERSION = 1
        const val DB_NAME = "app_database"
    }
}