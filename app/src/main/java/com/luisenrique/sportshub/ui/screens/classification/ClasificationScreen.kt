package com.luisenrique.sportshub.ui.screens.classification

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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.draw
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavController
import com.luisenrique.sportshub.domain.model.Classification
import com.luisenrique.sportshub.ui.components.ClasificationTeamItem
import com.luisenrique.sportshub.ui.components.MyText

@Composable
fun ClasificationScreen(
    modifier: Modifier,
    navController: NavController,
    viewModel: ClassificationViewModel = hiltViewModel()
) {
    val classifications by viewModel.classifications.collectAsState()

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
            itemsIndexed(classifications) { posicion, item ->
                ClasificationTeamItem(
                    posicion = posicion,
                    classification = item
                )
            }
        }
    }
}