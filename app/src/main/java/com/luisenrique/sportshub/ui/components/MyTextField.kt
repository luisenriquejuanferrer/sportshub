package com.luisenrique.sportshub.ui.components

import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle

@Composable
fun MyTextField(
    placeHolder: String,
    colors: TextFieldColors = TextFieldDefaults.colors(),
    modifier: Modifier,
    textStyle: TextStyle = LocalTextStyle.current
) {
    var text by remember { mutableStateOf("") }

    TextField(
        value = text,
        onValueChange = { newText -> text = newText },
        placeholder = { Text(placeHolder) },
        colors = colors,
        modifier = modifier,
        textStyle = textStyle
    )
}