package com.luisenrique.sportshub.ui.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MyOutlinedTextField(
    placeHolder: String,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = LocalTextStyle.current,
    colors: TextFieldColors = OutlinedTextFieldDefaults.colors(
        focusedBorderColor = Color.DarkGray,
        unfocusedBorderColor = Color.DarkGray
    )
) {
    var text by remember { mutableStateOf("") }

    OutlinedTextField(
        value = text,
        onValueChange = { text = it },
        placeholder = {
            Text(
                text = placeHolder,
                fontSize = 12.sp
            )
        },
        modifier = modifier
            .heightIn(min = 56.dp)
            .height(56.dp),
        textStyle = textStyle.copy(fontSize = 12.sp),
        singleLine = true,
        colors = colors
    )
}