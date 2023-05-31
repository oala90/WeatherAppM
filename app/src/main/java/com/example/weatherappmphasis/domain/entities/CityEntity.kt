package com.example.weatherappmphasis.domain.entities

data class CityEntity(
    val base: String?,
    val clouds: CloudsEntity?,
    val cod: Int?,
    val coord: CoordEntity?,
    val dt: Int?,
    val id: Int?,
    val main: MainEntity?,
    val name: String?,
    val sys: SysEntity?,
    val timezone: Int?,
    val visibility: Int?,
    val weather: List<WeatherEntity>?,
    val wind: WindEntity?
) {
    val icon: String
        get() = "https://openweathermap.org/img/wn/${weather?.first()?.icon}@2x.png"

}