package com.example.weatherappmphasis.presentation


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchTextCity(onTextChange: (String) -> Unit, onClickSearch: (String) -> Unit, text: String) {
    Column {
        TextField(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 50.dp, vertical = 50.dp),
            value = text,
            onValueChange = {
                onTextChange(it)
            },
            label = {
                Text(text = "Enter a US city")
            },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Search,
            ),
            keyboardActions = KeyboardActions(
                onSearch = {
                    onClickSearch(text)
                }
            ),
            maxLines = 1
        )
    }
}


@Preview
@Composable
fun TextPreview() {
    SearchTextCity({}, {}, "Chicago")
}