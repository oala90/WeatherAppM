package com.example.weatherappmphasis.domain.usecases.weather

import com.example.weatherappmphasis.domain.entities.CityEntity
import com.example.weatherappmphasis.domain.repositories.WeatherRepository
import com.example.weatherappmphasis.domain.usecases.base.UseCase
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class GetWeatherByCityUseCase @Inject constructor(
    private val repository: WeatherRepository,
    background: CoroutineDispatcher
): UseCase<CityEntity, String>(background) {
    override suspend fun run(input: String?): CityEntity {
        requireNotNull(input){ "City must not be null" }
        return repository.getWeatherByCityName(input)
    }
}