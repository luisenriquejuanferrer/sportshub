package com.luisenrique.sportshub.ui.components

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun MyButton(
    onClick: () -> Unit,
    enabled: Boolean,
    modifier: Modifier,
    colors: ButtonColors,
    text: String
) {
    Button(
        onClick = onClick,
        enabled = enabled,
        modifier = modifier,
        colors = colors
    ) {
        Text(text = text)
    }
}