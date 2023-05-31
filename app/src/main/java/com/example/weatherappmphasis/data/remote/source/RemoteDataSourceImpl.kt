package com.example.weatherappmphasis.data.remote.source

import com.example.weatherappmphasis.data.model.CityModel
import com.example.weatherappmphasis.data.remote.api.WeatherService
import com.example.weatherappmphasis.data.repositories.WeatherRemoteDataSource
import javax.inject.Inject

internal class RemoteDataSourceImpl @Inject constructor(
    private val weatherService: WeatherService
    ): WeatherRemoteDataSource
{
    override suspend fun getWeatherByCityName(city: String): CityModel {
        return weatherService.getWeatherByCityName(city)

    }
}