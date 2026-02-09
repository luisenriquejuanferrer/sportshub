package com.luisenrique.sportshub.ui.screens


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.luisenrique.sportshub.ui.components.DashboardBox
import com.luisenrique.sportshub.ui.navigation.Routes


@Composable
fun DashboardScreen(modifier: Modifier, navController: NavController) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(30.dp)
            ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,

                ) {
                DashboardBox(
                    "Ligas",
                    Color(0xFF4CAF50),
                    onClick = { navController.navigate(Routes.Leagues) })
                DashboardBox(
                    "Equipos",
                    Color(0xFF03A9F4),
                    onClick = { navController.navigate(Routes.Teams) })
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                DashboardBox(
                    "Partidos",
                    Color(0xFF49F527),
                    onClick = { navController.navigate(Routes.MatchesBase) })
                DashboardBox(
                    "Clasificación",
                    Color(0xFFED2600),
                    onClick = { navController.navigate(Routes.ClasificationBase) })
            }
        }
    }
}


