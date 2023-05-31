package com.example.weatherappmphasis.data.repositories

import com.example.weatherappmphasis.data.mapper.toEntity
import com.example.weatherappmphasis.data.model.CityModel
import com.example.weatherappmphasis.domain.entities.CityEntity
import com.example.weatherappmphasis.domain.repositories.WeatherRepository
import javax.inject.Inject

internal class WeatherRepositoryImpl @Inject constructor(
    private val remoteDataSource: WeatherRemoteDataSource,
    private val localDataSource: WeatherLocalDataSource
): WeatherRepository {
    override suspend fun getWeatherByCityName(city: String): CityEntity {
        localDataSource.writeCity(city)
        return remoteDataSource.getWeatherByCityName(city).toEntity()
    }

    override suspend fun loadCity(): String {
        return localDataSource.loadCity()
    }
}

internal interface WeatherRemoteDataSource {
    suspend fun getWeatherByCityName(city: String): CityModel
}

internal interface WeatherLocalDataSource {
    suspend fun writeCity(city: String)
    suspend fun loadCity(): String
}
