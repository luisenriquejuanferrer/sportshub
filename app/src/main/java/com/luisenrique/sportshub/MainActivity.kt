package com.luisenrique.sportshub

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.ieschabas.navigationcompose.navigation.SportsHubGraph
import com.luisenrique.sportshub.ui.components.BottomBar
import com.luisenrique.sportshub.ui.components.MainNavigationDrawer
import com.luisenrique.sportshub.ui.components.TopBar
import com.luisenrique.sportshub.ui.navigation.Routes
import com.luisenrique.sportshub.ui.theme.SportsHubTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()

            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.destination?.route


            val routesWithSimpleTopBar = listOf(
                Routes.LoginRegister,
                Routes.Register
            )

            val routesWithFullTopBar = listOf(
                Routes.Dashboard,
                Routes.Matches,
                Routes.MatchDetail,
                Routes.Teams,
                Routes.Bets,
                Routes.Profile,
                Routes.Leagues,
                Routes.LeagueDetail,
                Routes.Clasification,
                Routes.TeamDetail,
                Routes.PlayerDetail
            )


            val topBarTitle = when (currentRoute) {
                Routes.LoginRegister -> "Acceso"
                Routes.Register -> "Registro de usuario"
                Routes.Matches -> "Partidos"
                Routes.MatchDetail -> "Detalle de partido"
                Routes.Teams -> "Equipos"
                Routes.Bets -> "Apuesta"
                Routes.Profile -> "Mi Cuenta"
                Routes.Leagues -> "Ligas"
                Routes.LeagueDetail -> "Detalle de liga"
                Routes.Clasification -> "Clasificación"
                Routes.TeamDetail -> "Detalle de equipo"
                Routes.PlayerDetail -> "Detalle de jugador"
                else -> "Sports Hub - IES Chabàs"
            }

            val showFullUI = currentRoute in routesWithFullTopBar
            val showSimpleTopBar = currentRoute in routesWithSimpleTopBar

            var currentScreen by remember { mutableStateOf("Inicio") }

            SportsHubTheme {
                when {
                    showFullUI -> {
                        val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
                        val scopeDrawer = rememberCoroutineScope()

                        MainNavigationDrawer(drawerState, navController = navController) {
                            Scaffold(
                                modifier = Modifier.fillMaxSize(),
                                topBar = {
                                    TopBar(topBarTitle, drawerState, scopeDrawer)
                                },
                                bottomBar = {
                                    BottomBar(
                                        selectedItem = currentScreen,
                                        navController = navController,
                                        onItemClick = { item -> currentScreen = item }
                                    )

                                }
                            ) { innerPadding ->
                                SportsHubGraph(
                                    modifier = Modifier.padding(innerPadding),
                                    navController = navController
                                )
                            }
                        }
                    }
                    showSimpleTopBar -> {
                        Scaffold(
                            modifier = Modifier.fillMaxSize(),
                            topBar = {
                                TopAppBar(
                                    title = { Text(topBarTitle, color = Color.White) },
                                    colors = TopAppBarDefaults.topAppBarColors(
                                        containerColor = colorResource(R.color.azul_petroleo)
                                    )
                                )
                            }
                        ) { innerPadding ->
                            SportsHubGraph(
                                modifier = Modifier.padding(innerPadding),
                                navController = navController
                            )
                        }
                    }
                    else -> {
                        SportsHubGraph(
                            modifier = Modifier.fillMaxSize(),
                            navController = navController
                        )
                    }
                }
            }
        }
    }
}