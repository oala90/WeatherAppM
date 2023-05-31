package com.example.weatherappmphasis.data.local.source

import com.example.weatherappmphasis.data.local.preferences.SavePref
import com.example.weatherappmphasis.data.repositories.WeatherLocalDataSource
import javax.inject.Inject

class WeatherLocalDataSourceImpl @Inject constructor(private val savePref: SavePref ):
    WeatherLocalDataSource {
    override suspend fun writeCity(city: String) {
        savePref.city = city
    }

    override suspend fun loadCity(): String {
        return savePref.city ?: ""
    }
}

