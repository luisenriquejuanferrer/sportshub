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
import com.luisenrique.sportshub.ui.components.BottomBar
import com.luisenrique.sportshub.ui.components.MainNavigationDrawer
import com.luisenrique.sportshub.ui.components.TopBar
import com.luisenrique.sportshub.ui.navigation.Routes
import com.luisenrique.sportshub.ui.navigation.SportsHubGraph
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


            // ... (código anterior)

            // CAMBIAMOS EL 'when' PARA QUE SEA MÁS ROBUSTO
            val topBarTitle = remember(currentRoute) { // Usamos remember para eficiencia
                when {
                    currentRoute?.startsWith(Routes.LoginRegister) == true -> "Acceso"
                    currentRoute?.startsWith(Routes.Register) == true -> "Registro de usuario"
                    currentRoute?.startsWith(Routes.Matches) == true -> "Partidos"
                    currentRoute?.startsWith(Routes.MatchDetail) == true -> "Detalle de partido"
                    currentRoute?.startsWith(Routes.Teams) == true -> "Equipos"
                    currentRoute?.startsWith(Routes.Bets) == true -> "Apuesta"
                    currentRoute?.startsWith(Routes.Profile) == true -> "Mi Cuenta"
                    currentRoute?.startsWith(Routes.Leagues) == true -> "Ligas"
                    currentRoute?.startsWith(Routes.LeagueDetail) == true -> "Detalle de liga"
                    currentRoute?.startsWith(Routes.Clasification) == true -> "Clasificación"
                    currentRoute?.startsWith(Routes.TeamDetail) == true -> "Detalle de equipo" // <-- ESTA LÍNEA AHORA FUNCIONARÁ
                    currentRoute?.startsWith(Routes.PlayerDetail) == true -> "Detalle de jugador"
                    else -> "Sports Hub - IES Chabàs"
                }
            }


            val showFullUI = routesWithFullTopBar.any { currentRoute?.startsWith(it) == true }
            val showSimpleTopBar = routesWithSimpleTopBar.any { currentRoute?.startsWith(it) == true }

// ... (el resto del código sigue igual)


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