package com.luisenrique.sportshub.ui.screens.matches

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavController
import com.luisenrique.sportshub.ui.components.MatchItem
import com.luisenrique.sportshub.ui.navigation.Routes

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MatchesScreen(
    modifier: Modifier,
    navController: NavController,
    viewModel: MatchesViewModel = hiltViewModel()
) {
    val matches by viewModel.matches.collectAsStateWithLifecycle()

    if (matches.isEmpty()) {
        Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text("No hay partidos disponibles", color = Color.Gray)
        }
    } else {
    LazyColumn(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        itemsIndexed(matches) { _, item ->
            MatchItem(
                partido = item,
                onClick = { navController.navigate(Routes.createMatchDetailRoute(item.id)) }
            )
            HorizontalDivider()
        }
    }
    }
}