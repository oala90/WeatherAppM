package com.example.weatherappmphasis.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: WeatherViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            LaunchedEffect(key1 = true){
                viewModel.loadCityOnSharedPref()
            }

            val searchState: String by viewModel.searchCity

            val city by viewModel.cityWeather.collectAsState()

            val cityPreferences by viewModel.citySharedPref.collectAsState()

            if (!cityPreferences.isNullOrBlank()){
                viewModel.getWeatherByCity(cityPreferences.toString())
            }
            // A surface container using the 'background' color from the theme
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = Color.White
            ) {
                Column() {
                    SearchTextCity(
                        onTextChange = {
                            viewModel.searchCity.value = it
                        },
                        onClickSearch = {
                            viewModel.getWeatherByCity(searchState)
                        },
                        text = searchState
                    )
                    Spacer(modifier = Modifier.size(100.dp))

                    CityViewContainer(cityEntity = city)
                }

            }
        }
    }
}
