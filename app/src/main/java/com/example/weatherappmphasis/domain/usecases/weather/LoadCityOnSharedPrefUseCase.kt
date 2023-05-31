package com.example.weatherappmphasis.domain.usecases.weather

import com.example.weatherappmphasis.domain.repositories.WeatherRepository
import com.example.weatherappmphasis.domain.usecases.base.UseCase
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class LoadCityOnSharedPrefUseCase @Inject constructor(
    private val repository: WeatherRepository,
    background: CoroutineDispatcher
): UseCase<String, Unit>(background) {
    override suspend fun run(input: Unit?): String {
        return repository.loadCity()
    }
}