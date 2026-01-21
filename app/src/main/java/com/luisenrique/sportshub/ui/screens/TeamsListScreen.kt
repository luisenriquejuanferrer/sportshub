package com.luisenrique.sportshub.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.luisenrique.sportshub.domain.model.Equipo
import com.luisenrique.sportshub.domain.model.Player
import com.luisenrique.sportshub.ui.navigation.Routes

@Composable
fun TeamsListScreen(
    modifier: Modifier,
    navController: NavController
) {

    val equipo = listOf(
        Equipo("Equipo 1", "-", "-"),
        Equipo("Equipo 2", "-", "-"),
        Equipo("Equipo 3", "-", "-"),
        Equipo("Equipo 4", "-", "-"),
        Equipo("Equipo 5", "-", "-"),
        Equipo("Equipo 6", "-", "-"),
        Equipo("Equipo 7", "-", "-"),
    )

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(equipo) { equipo ->
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .background(
                        color = Color(0xFF7FF0F0),
                        shape = RoundedCornerShape(12.dp)
                    )
                    .padding(16.dp)
                    .clickable { navController.navigate(Routes.TeamDetail) },
                contentAlignment = Alignment.TopStart
            ) {
                Column {
                    Text(
                        text = equipo.nombre,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "Ciudad: ${equipo.ciudad}",
                        fontSize = 14.sp
                    )
                    Text(
                        text = "IES: ${equipo.ies}",
                        fontSize = 14.sp
                    )
                }
            }
        }
    }
}

