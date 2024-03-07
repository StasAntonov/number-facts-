package com.example.numberfacts.di

import android.content.Context
import androidx.room.Room
import com.example.numberfacts.data.datasource.local.dao.NumbersDao
import com.example.numberfacts.data.datasource.local.database.AppDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalModule {

    @Provides
    @Singleton
    fun provideDataBase(@ApplicationContext context: Context): AppDataBase {
        return Room.databaseBuilder(
            context,
            AppDataBase::class.java,
            AppDataBase.DB_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideNumbersDao(appDataBase: AppDataBase): NumbersDao {
        return appDataBase.numbersDao()
    }

}