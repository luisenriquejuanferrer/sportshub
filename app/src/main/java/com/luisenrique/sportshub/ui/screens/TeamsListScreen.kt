package com.luisenrique.sportshub.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun TeamsListScreen() {

    val equipos = listOf(
        "Equipo 1",
        "Equipo 2",
        "Equipo 3",
        "Equipo 4",
        "Equipo 5",
        "Equipo 6",
        "Equipo 7"
    )

    LazyColumn (
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ){
        items(equipos){ equipos ->
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .background(
                        color = Color(0xFF7FF0F0),
                        shape = RoundedCornerShape(12.dp)
                    )
                    .padding(16.dp),
                contentAlignment = Alignment.TopStart
            ){
                Column {
                    Text(
                        text = equipos,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "Ciudad: -",
                        fontSize = 14.sp
                    )
                   Text(
                       text = "IES: -",
                       fontSize = 14.sp
                   )

                }
            }
        }
    }


}

@Preview(showBackground = true)
@Composable
fun TeamsListScreenPreview() {
    TeamsListScreen()
}