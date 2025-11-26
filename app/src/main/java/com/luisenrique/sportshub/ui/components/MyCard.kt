package com.luisenrique.sportshub.ui.components

import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun MyCard(
    modifier: Modifier,
    colors: CardColors,
    onClick: () -> Unit = { },
    content: @Composable () -> Unit = { },
) {
    Card(
        modifier = modifier,
        colors = colors,
        onClick = onClick
    ) {
        content()
    }
}