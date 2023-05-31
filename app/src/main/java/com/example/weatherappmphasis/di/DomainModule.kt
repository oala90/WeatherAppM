package com.example.weatherappmphasis.di

import com.example.weatherappmphasis.domain.repositories.WeatherRepository
import com.example.weatherappmphasis.domain.usecases.weather.GetWeatherByCityUseCase
import com.example.weatherappmphasis.domain.usecases.weather.LoadCityOnSharedPrefUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DomainModule {

    @Singleton
    @Provides
    fun provideGetWeatherByCityUseCase(
        repository: WeatherRepository,
        background: CoroutineDispatcher
    ) = GetWeatherByCityUseCase(repository, background)

    @Singleton
    @Provides
    fun provideLoadCityOnSharedPrefUseCase(
        repository: WeatherRepository,
        background: CoroutineDispatcher
    ) = LoadCityOnSharedPrefUseCase(repository, background)

}