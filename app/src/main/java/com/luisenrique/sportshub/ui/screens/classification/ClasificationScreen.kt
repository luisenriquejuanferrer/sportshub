package com.luisenrique.sportshub.ui.screens.classification

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.luisenrique.sportshub.R
import com.luisenrique.sportshub.ui.components.ClasificationApiItem
import com.luisenrique.sportshub.ui.components.ClasificationTeamItem
import com.luisenrique.sportshub.ui.components.MyText

@Composable
fun ClasificationScreen(
    modifier: Modifier,
    viewModel: ClassificationViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(colorResource(R.color.azul_petroleo))
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                MyText(text = "#", color = Color.White, modifier = Modifier.weight(0.7f))
                MyText(text = "Club", color = Color.White, modifier = Modifier.weight(1f))
                MyText(text = "Equipo", color = Color.White, modifier = Modifier.weight(2f))
                MyText(text = "PJ", color = Color.White, modifier = Modifier.weight(1f))
                MyText(text = "G", color = Color.White, modifier = Modifier.weight(1f))
                MyText(text = "E", color = Color.White, modifier = Modifier.weight(1f))
                MyText(text = "P", color = Color.White, modifier = Modifier.weight(1f))
                MyText(text = "Pts", color = Color.White, modifier = Modifier.weight(1f))
            }
        }

        when (val state = uiState) {
            is ClassificationUiState.Loading -> {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Text("Cargando...", color = Color.Gray)
                }
            }
            is ClassificationUiState.FromApi -> {
                if (state.items.isEmpty()) {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        Text("No hay clasificación disponible", color = Color.Gray)
                    }
                } else {
                    LazyColumn(modifier = Modifier.fillMaxWidth()) {
                        itemsIndexed(state.items) { posicion, item ->
                            ClasificationApiItem(posicion = posicion, item = item)
                        }
                    }
                }
            }
            is ClassificationUiState.FromRoom -> {
                if (state.items.isEmpty()) {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        Text("No hay clasificación disponible", color = Color.Gray)
                    }
                } else {
                    LazyColumn(modifier = Modifier.fillMaxWidth()) {
                        itemsIndexed(state.items) { posicion, item ->
                            ClasificationTeamItem(posicion = posicion, classification = item)
                        }
                    }
                }
            }
        }
    }
}
