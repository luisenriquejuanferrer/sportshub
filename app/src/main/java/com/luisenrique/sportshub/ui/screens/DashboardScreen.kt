package com.ieschabas.sportshub.ui.screens


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color


import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun DashboardScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        contentAlignment = Alignment.TopCenter
    ){
        Column (
            modifier = Modifier
                .padding(top = 90.dp),
            verticalArrangement = Arrangement.spacedBy(30.dp),

        ){
            Row(

                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,

            ) {
                DashboardBox("Ligas", Color(0xFF4CAF50))
                DashboardBox("Equipos", Color(0xFF03A9F4))
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                DashboardBox("Partidos", Color(0xFF49F527))
                DashboardBox("Clasificación", Color(0xFFED2600))
            }
        }
    }



}

@Composable
fun DashboardBox(text: String, color: Color) {
    Box(
        modifier = Modifier
            .width(175.dp)
            .height(270.dp)
            .background(color),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            color = Color.White
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DashboardScreenPreview() {
    DashboardScreen()
}