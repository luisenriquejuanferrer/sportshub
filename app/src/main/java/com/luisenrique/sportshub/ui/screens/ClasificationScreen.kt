package com.luisenrique.sportshub.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.luisenrique.sportshub.domain.model.Clasificacion
import com.luisenrique.sportshub.ui.components.ClasificationTeamItem
import com.luisenrique.sportshub.ui.components.MyText

@Composable
fun ClasificationScreen(modifier: Modifier, navController: NavController) {
    val equipos = listOf(
        Clasificacion("Equipo 1", "11", "7", "2", "2", "21"),
        Clasificacion("Equipo 2", "12", "8", "2", "2", "22"),
        Clasificacion("Equipo 3", "13", "6", "2", "2", "23"),
        Clasificacion("Equipo 4", "14", "7", "2", "2", "24"),
        Clasificacion("Equipo 5", "15", "8", "2", "2", "25"),
        Clasificacion("Equipo 6", "16", "6", "2", "2", "26"),
        Clasificacion("Equipo 7", "17", "7", "2", "2", "27"),
        Clasificacion("Equipo 8", "18", "8", "2", "2", "28"),
        Clasificacion("Equipo 9", "19", "6", "2", "2", "29"),
        Clasificacion("Equipo 10", "20", "7", "2", "2", "30"),
    )

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    Color.Cyan
                )
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                MyText(
                    text = "Club",
                    modifier = Modifier.weight(1f)
                )
                MyText(
                    text = "Equipo",
                    modifier = Modifier.weight(2f)
                )
                MyText(
                    text = "PJ",
                    modifier = Modifier.weight(1f)
                )
                MyText(
                    text = "G",
                    modifier = Modifier.weight(1f)
                )
                MyText(
                    text = "E",
                    modifier = Modifier.weight(1f)
                )
                MyText(
                    text = "P",
                    modifier = Modifier.weight(1f)
                )
                MyText(
                    text = "Pts",
                    modifier = Modifier.weight(1f)
                )
            }
        }
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            itemsIndexed(equipos) { posicion, equipo ->
                ClasificationTeamItem(posicion, equipo)
                HorizontalDivider()
            }
        }
    }
}