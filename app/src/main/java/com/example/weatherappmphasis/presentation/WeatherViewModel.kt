package com.example.weatherappmphasis.presentation

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherappmphasis.domain.entities.CityEntity
import com.example.weatherappmphasis.domain.usecases.weather.GetWeatherByCityUseCase
import com.example.weatherappmphasis.domain.usecases.weather.LoadCityOnSharedPrefUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val getWeatherByCityUseCase: GetWeatherByCityUseCase,
    private val loadCityOnSharedPrefUseCase: LoadCityOnSharedPrefUseCase
) : ViewModel() {

    val searchCity = mutableStateOf("")

    private val _cityWeather = MutableStateFlow<CityEntity?>(null)
    val cityWeather = _cityWeather.asStateFlow()

    private val _citySharedPref = MutableStateFlow<String?>(null)
    val citySharedPref = _citySharedPref.asStateFlow()

    fun getWeatherByCity(city: String) = viewModelScope.launch(Dispatchers.Main) {
        getWeatherByCityUseCase(city).fold({ cityEntity ->
            _cityWeather.value = cityEntity
        }, {
            _cityWeather.value = null
            Timber.e(it)
        })
    }

    fun loadCityOnSharedPref() {
        viewModelScope.launch {
            loadCityOnSharedPrefUseCase().fold({
                _citySharedPref.value = it
            },{

            })
        }

    }

}