package com.luisenrique.sportshub.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.luisenrique.sportshub.R
import com.luisenrique.sportshub.ui.navigation.Routes

@Composable
fun BottomBar(
    selectedItem: String = "Inicio",
    navController: NavController,
    onItemClick: (String) -> Unit = {}
) {
    NavigationBar(containerColor = colorResource(id = R.color.azul_petroleo)) {

        NavigationBarItem(
            selected = selectedItem == "Inicio",
            onClick = {
                onItemClick("Inicio")
                navController.navigate(Routes.Dashboard)
            },
            label = { Text("Inicio", color = Color.White) },
            icon = { Icon(Icons.Filled.Home, contentDescription = "Inicio") },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.Black,
                unselectedIconColor = Color.White
            )
        )

        NavigationBarItem(
            selected = selectedItem == "Ligas",
            onClick = {
                onItemClick("Ligas")
                navController.navigate(Routes.Leagues)
            },
            label = { Text("Ligas", color = Color.White) },
            icon = { Icon(Icons.Filled.List, contentDescription = "Ligas") },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.Black,
                unselectedIconColor = Color.White
            )
        )
        NavigationBarItem(
            selected = selectedItem == "Partidos",
            onClick = {
                onItemClick("Partidos")
                navController.navigate(Routes.Matches)
            },
            label = { Text("Partidos", color = Color.White) },
            icon = { Icon(Icons.Filled.Star, contentDescription = "Equipos") },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.Black,
                unselectedIconColor = Color.White
            )
        )

        NavigationBarItem(
            selected = selectedItem == "Perfil",
            onClick = {
                onItemClick("Perfil")
                navController.navigate(Routes.Profile)
            },
            label = { Text("Perfil", color = Color.White) },
            icon = { Icon(Icons.Filled.Person, contentDescription = "Perfil") },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.Black,
                unselectedIconColor = Color.White
            )
        )

    }
}
