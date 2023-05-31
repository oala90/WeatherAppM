package com.example.weatherappmphasis.domain.repositories

import com.example.weatherappmphasis.domain.entities.CityEntity

interface WeatherRepository {
    suspend fun getWeatherByCityName(city: String): CityEntity
    suspend fun loadCity(): String
}