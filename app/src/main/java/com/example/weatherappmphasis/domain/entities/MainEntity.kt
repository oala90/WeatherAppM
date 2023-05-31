package com.example.weatherappmphasis.domain.entities

data class MainEntity(
    val feels_like: Double?,
    val humidity: Int?,
    val pressure: Int?,
    val temp: Double?,
    val temp_max: Double?,
    val temp_min: Double?
)