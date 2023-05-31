package com.example.weatherappmphasis.di

import com.example.weatherappmphasis.data.local.source.WeatherLocalDataSourceImpl
import com.example.weatherappmphasis.data.remote.source.RemoteDataSourceImpl
import com.example.weatherappmphasis.data.repositories.WeatherLocalDataSource
import com.example.weatherappmphasis.data.repositories.WeatherRemoteDataSource
import com.example.weatherappmphasis.data.repositories.WeatherRepositoryImpl
import com.example.weatherappmphasis.domain.repositories.WeatherRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {
    @Binds
    internal abstract fun bindRemoteDataSource(
        remoteDataSourceImpl: RemoteDataSourceImpl
    ): WeatherRemoteDataSource

    @Binds
    internal abstract fun bindWeatherRepository(
        weatherRepositoryImpl: WeatherRepositoryImpl
    ): WeatherRepository

    @Binds
    internal abstract fun bindLocalDataSource(
        localDataSourceImpl: WeatherLocalDataSourceImpl
    ): WeatherLocalDataSource
}