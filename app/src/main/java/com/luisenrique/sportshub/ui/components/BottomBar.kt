package com.luisenrique.sportshub.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import com.luisenrique.sportshub.R

@Composable
fun BottomBar(
        selectedItem: String = "Inicio",
        onItemClick: (String) -> Unit = {}
){
    NavigationBar(containerColor = colorResource(id = R.color.azul_petroleo)) {

        NavigationBarItem(
            selected = selectedItem == "Inicio",
            onClick = { },
            label = { Text("Inicio", color = Color.White) },
            icon = { Icon(Icons.Filled.Home, contentDescription = "Inicio") },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.Black,
                unselectedIconColor = Color.White
            )
        )

        NavigationBarItem(
            selected = selectedItem == "Ligas",
            onClick = { onItemClick("Ligas") },
            label = { Text("Ligas", color = Color.White) },
            icon = { Icon(Icons.Filled.List, contentDescription = "Ligas")},
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.Black,
                unselectedIconColor = Color.White
            )
        )
        NavigationBarItem(
            selected = selectedItem == "Equipos",
            onClick = { onItemClick("Equipos") },
            label = { Text("Equipos", color = Color.White) },
            icon = { Icon(Icons.Filled.Star, contentDescription = "Equipos")},
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.Black,
                unselectedIconColor = Color.White
            )
        )

        NavigationBarItem(
            selected = selectedItem == "Perfil",
            onClick = { onItemClick("Perfil") },
            label = { Text("Perfil", color = Color.White) },
            icon = { Icon(Icons.Filled.Person, contentDescription = "Perfil")},
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.Black,
                unselectedIconColor = Color.White
            )
        )

    }
}

@Preview(showBackground = true)
@Composable
fun BottomBarPreview() {
    BottomBar()
}