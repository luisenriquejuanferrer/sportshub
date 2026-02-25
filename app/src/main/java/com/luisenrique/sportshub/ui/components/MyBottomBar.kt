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
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.luisenrique.sportshub.R
import com.luisenrique.sportshub.ui.navigation.Routes

@Composable
fun BottomBar(
    navController: NavController,
    onItemClick: () -> Unit = { }
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    NavigationBar(containerColor = colorResource(id = R.color.azul_petroleo)) {
        NavigationBarItem(
            selected = currentRoute?.startsWith(Routes.Dashboard) == true,
            onClick = {
                onItemClick()
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
            selected = currentRoute?.startsWith(Routes.Leagues) == true,
            onClick = {
                onItemClick()
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
            selected = currentRoute?.startsWith(Routes.MatchesBase) == true,
            onClick = {
                onItemClick()
                navController.navigate(Routes.MatchesBase)
            },
            label = { Text("Partidos", color = Color.White) },
            icon = { Icon(Icons.Filled.Star, contentDescription = "Partidos") },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.Black,
                unselectedIconColor = Color.White
            )
        )
        NavigationBarItem(
            selected = currentRoute?.startsWith(Routes.Profile) == true,
            onClick = {
                onItemClick()
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
