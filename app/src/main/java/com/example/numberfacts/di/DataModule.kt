package com.example.numberfacts.di

import com.example.numberfacts.data.datasource.local.LocalDataSource
import com.example.numberfacts.data.datasource.remote.RemoteDataSource
import com.example.numberfacts.domain.local.ILocalDataSource
import com.example.numberfacts.domain.remote.IRemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {
    @Binds
    @Singleton
    abstract fun bindRemoteDataSource(
        remoteDataSource: RemoteDataSource
    ): IRemoteDataSource

    @Binds
    @Singleton
    abstract fun bindLocalDataSource(
        localDataSource: LocalDataSource
    ): ILocalDataSource
}