package com.example.numberfacts.di

import com.example.numberfacts.data.repository.NumberRepositoryImpl
import com.example.numberfacts.domain.repository.INumberRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DomainModule {
    @Binds
    @Singleton
    abstract fun bindNumberRepository(
        repository: NumberRepositoryImpl
    ): INumberRepository
}