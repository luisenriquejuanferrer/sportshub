package com.luisenrique.sportshub.ui.screens.leagues

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavController
import com.luisenrique.sportshub.ui.components.MyCard
import com.luisenrique.sportshub.ui.components.MyText
import com.luisenrique.sportshub.ui.navigation.Routes

data class Liga(val name: String, val city: String)

@Composable
fun LeagueListScreen(
    modifier: Modifier,
    navController: NavController,
    viewModel: LeaguesViewModel = hiltViewModel()
) {
    val leagues by viewModel.leagues.collectAsState()
    LazyColumn(
        modifier = modifier
            .padding(16.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        itemsIndexed(leagues) { posicion, item ->
            MyCard(
                modifier = Modifier
                    .padding()
                    .fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFF3aa57a)
                ),
                onClick = { navController.navigate(Routes.LeagueDetail) }
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    MyText(text = item.name, fontSize = 22.sp)
                    Row {
                        MyText("País:")
                        Spacer(Modifier.padding(4.dp))
                        MyText(item.country)
                    }
                }
            }
            Spacer(Modifier.padding(vertical = 8.dp))
        }
    }
}