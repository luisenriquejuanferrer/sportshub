package com.luisenrique.sportshub.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import com.luisenrique.sportshub.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    title: String,
    drawerState: DrawerState,
    scopeDrawer: CoroutineScope
) {
    TopAppBar(
        title = {
            Text(
                text = title,
                color = Color.White
            )
        },
        navigationIcon = {
            IconButton(
                onClick = {
                    scopeDrawer.launch { drawerState.open() }
                }) {
                Icon(Icons.Default.Menu, "Menu icon", tint = Color.White)
            }

        },
        colors = TopAppBarDefaults.topAppBarColors(
            colorResource(id = R.color.azul_petroleo)
        )
    )
}
