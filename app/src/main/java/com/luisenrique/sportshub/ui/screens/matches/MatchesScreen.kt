package com.luisenrique.sportshub.ui.screens.matches

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavController
import com.luisenrique.sportshub.ui.components.MatchItem

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MatchesScreen(
    modifier: Modifier,
    navController: NavController,
    viewModel: MatchesViewModel = hiltViewModel(),
    onMatchClick: (String) -> Unit
) {
    val matches by viewModel.matches.collectAsState()

    LazyColumn(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        itemsIndexed(matches) { _, item ->
            MatchItem(
                partido = item,
                onClick = { onMatchClick(item.id) })
            HorizontalDivider()
        }
    }
}