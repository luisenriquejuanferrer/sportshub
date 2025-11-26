package com.luisenrique.sportshub.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.luisenrique.sportshub.ui.components.MyCard
import com.luisenrique.sportshub.ui.components.MyText

data class Liga(val name: String, val city: String)

@Composable
fun LeagueListScreen(modifier: Modifier, navController: NavController) {
    val ligas = listOf(
        Liga("LaLiga", "--"),
        Liga("Premier League", "--"),
        Liga("Serie A", "--"),
        Liga("Bundesliga", "--"),
        Liga("Ligue 1", "--"),
        Liga("Eredivisie", "--")
    )

    LazyColumn(
        modifier = modifier
            .padding(16.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(ligas.size) { i ->
            MyCard(
                modifier = Modifier
                    .padding()
                    .fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFF3aa57a)
                ),
                onClick = { navController.navigate("ligaDetails") }
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    MyText(text = ligas[i].name, fontSize = 22.sp)
                    Row {
                        MyText("Ciudad:")
                        Spacer(Modifier.padding(4.dp))
                        MyText(ligas[i].city)
                    }
                }
            }
            Spacer(Modifier.padding(vertical = 8.dp))
        }
    }
}