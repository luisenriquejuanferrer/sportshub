package com.luisenrique.sportshub.ui.screens

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.luisenrique.sportshub.ui.components.MatchItem

data class Partido(
    val fecha: String,
    val local: String,
    val visitante: String,
    val resultado: String
)

@Composable
fun MatchesScreen(modifier: Modifier) {
    val partidos = listOf(
        Partido("Sab 20:46", "fx.home", "fx.away", "  -  "),
        Partido("Sab 20:47", "fx.home", "fx.away", "0 - 0"),
        Partido("Sab 20:48", "fx.home", "fx.away", "  -  "),
        Partido("Sab 20:49", "fx.home", "fx.away", "0 - 0"),
        Partido("Sab 20:50", "fx.home", "fx.away", "  -  "),
    )

    LazyColumn(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        items(partidos) { partido ->
            MatchItem(partido)
            HorizontalDivider()
        }
    }
}