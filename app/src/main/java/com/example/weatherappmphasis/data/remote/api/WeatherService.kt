package com.example.weatherappmphasis.data.remote.api

import com.example.weatherappmphasis.data.model.CityModel
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {

    @GET("weather")
    suspend fun getWeatherByCityName(
        @Query("q") city: String,
    ): CityModel
}