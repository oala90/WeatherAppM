package com.example.weatherappmphasis.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.weatherappmphasis.domain.entities.CityEntity

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun CityViewContainer(cityEntity: CityEntity?) {
    if (cityEntity == null) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text(
                modifier = Modifier,
                text = "City must be entered",
            )
        }
        return
    }
    Card(
        modifier = Modifier
            .background(Color.White)
            .padding(horizontal = 15.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
        shape = RoundedCornerShape(5.dp),
    ) {
        Row(
            modifier = Modifier
                .background(Color.White)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Column(
            ) {
                Text(
                    text = cityEntity.name.toString(), modifier = Modifier
                        .padding(5.dp)
                )
                Row {
                    Text(
                        text = "Weather: ${cityEntity.weather?.first()?.description}", modifier = Modifier
                            .padding(5.dp)
                    )
                    GlideImage(model = cityEntity.icon , contentDescription =null, modifier = Modifier.size(35.dp))
                }
            }
            Column() {
                Text(
                    text = "Temperature ${cityEntity.main?.temp} F", modifier = Modifier
                        .padding(5.dp)
                )
                Text(
                    text = "Feels Like: ${cityEntity.main?.feels_like} F", modifier = Modifier
                        .padding(5.dp)
                )
            }
        }
    }

}

@Preview
@Composable
fun PreviewCityContainer() {
    CityViewContainer(null)
}