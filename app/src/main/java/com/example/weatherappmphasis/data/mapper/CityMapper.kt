package com.example.weatherappmphasis.data.mapper

import com.example.weatherappmphasis.data.model.CityModel
import com.example.weatherappmphasis.data.model.Clouds
import com.example.weatherappmphasis.data.model.Coord
import com.example.weatherappmphasis.data.model.Main
import com.example.weatherappmphasis.data.model.Sys
import com.example.weatherappmphasis.data.model.Weather
import com.example.weatherappmphasis.data.model.Wind
import com.example.weatherappmphasis.domain.entities.CityEntity
import com.example.weatherappmphasis.domain.entities.CloudsEntity
import com.example.weatherappmphasis.domain.entities.CoordEntity
import com.example.weatherappmphasis.domain.entities.MainEntity
import com.example.weatherappmphasis.domain.entities.SysEntity
import com.example.weatherappmphasis.domain.entities.WeatherEntity
import com.example.weatherappmphasis.domain.entities.WindEntity

fun CityModel.toEntity() = CityEntity(
    base = base,
    clouds = clouds?.toEntity(),
    cod = cod,
    coord = coord?.toEntity(),
    dt = dt,
    id = id,
    main = main?.toEntity(),
    name = name,
    sys = sys?.toEntity(),
    timezone = timezone,
    visibility = visibility,
    weather = weather?.map { obj -> obj.toEntity() },
    wind = wind?.toEntity()
)

fun Clouds.toEntity() = CloudsEntity(
    all = all
)

fun Coord.toEntity() = CoordEntity(
    lat = lat,
    lon = lon
)

fun Main.toEntity() = MainEntity(
    feels_like = feels_like,
    humidity = humidity,
    pressure = pressure,
    temp = temp,
    temp_max = temp_max,
    temp_min = temp_min
)

fun Sys.toEntity() = SysEntity(
    country = country,
    id = id,
    sunrise = sunrise,
    sunset = sunset,
    type = type
)

fun Weather.toEntity() = WeatherEntity(
    description = description,
    icon = icon,
    id = id,
    main = main
)

fun Wind.toEntity() = WindEntity(
    deg = deg,
    speed = speed
)