package com.luisenrique.sportshub.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.DrawerState
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun MainNavigationDrawer(drawerState: DrawerState, navController: NavController, content: @Composable () -> Unit) {
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                Text("SportsHub Chabàs", modifier = Modifier.padding(16.dp))
                HorizontalDivider(modifier = Modifier.padding(horizontal = 16.dp))
                NavigationDrawerItem(
                    label = {
                        Text("Ligas")
                    },
                    selected = false,
                    onClick = {
                        navController.navigate("ligas")
                    }
                )
                NavigationDrawerItem(
                    label = {
                        Text("Equipos")
                    },
                    selected = false,
                    onClick = {
                        navController.navigate("equipos")
                    }
                )
                NavigationDrawerItem(
                    label = {
                        Text("Partidos")
                    },
                    selected = false,
                    onClick = {
                        navController.navigate("partidos")
                    }
                )
                NavigationDrawerItem(
                    label = {
                        Text("Clasificación")
                    },
                    selected = false,
                    onClick = {
                        navController.navigate("clasificacion")
                    }
                )

                NavigationDrawerItem(
                    label = {
                        Text("Apuestas")
                    },
                    selected = false,
                    onClick = {
                        navController.navigate("apuestas")
                    }
                )

                HorizontalDivider(modifier = Modifier.padding(horizontal = 16.dp))
                NavigationDrawerItem(
                    label = {
                        Text("Inicio")
                    },
                    selected = false,
                    onClick = {
                        navController.navigate("dashboard")
                    }, icon = {
                        Icon(Icons.Default.Home, "Home button")
                    }
                )
                NavigationDrawerItem(
                    label = {
                        Text("Perfil")
                    },
                    selected = false,
                    onClick = {
                        navController.navigate("perfil")
                    }, icon = {
                        Icon(Icons.Default.Person, "Profile button")
                    }
                )
            }
        }
    ){
        content()
    }
}