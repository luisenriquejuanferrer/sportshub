package com.luisenrique.sportshub

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.google.firebase.Firebase
import com.google.firebase.messaging.messaging
import com.luisenrique.sportshub.ui.components.BottomBar
import com.luisenrique.sportshub.ui.components.MainNavigationDrawer
import com.luisenrique.sportshub.ui.components.TopBar
import com.luisenrique.sportshub.ui.navigation.Routes
import com.luisenrique.sportshub.ui.navigation.SportsHubGraph
import com.luisenrique.sportshub.ui.theme.SportsHubTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            retrieveToken()

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

            val topBarTitle = remember(currentRoute) {
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
                    currentRoute?.startsWith(Routes.TeamDetail) == true -> "Detalle de equipo"
                    currentRoute?.startsWith(Routes.PlayerDetail) == true -> "Detalle de jugador"
                    else -> "Sports Hub - IES Chabàs"
                }
            }

            val showFullUI = routesWithFullTopBar.any { currentRoute?.startsWith(it) == true }
            val showSimpleTopBar = routesWithSimpleTopBar.any { currentRoute?.startsWith(it) == true }

            var currentScreen by remember { mutableStateOf("Inicio") }

            SportsHubTheme {
                val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
                val scopeDrawer = rememberCoroutineScope()

                var isBottomBarVisible by remember { mutableStateOf(true) }
                var lastInteraction by remember { mutableStateOf(System.currentTimeMillis()) }

                LaunchedEffect(lastInteraction) {
                    delay(3000)
                    isBottomBarVisible = false
                }

                fun Modifier.userInteraction(onInteraction: () -> Unit) = pointerInput(Unit) {
                    awaitPointerEventScope {
                        while (true) {
                            awaitPointerEvent()
                            onInteraction()
                        }
                    }
                }

                MainNavigationDrawer(
                    drawerState = drawerState,
                    navController = navController
                ) {
                    Scaffold(
                        modifier = Modifier
                            .fillMaxSize()
                            .userInteraction {
                                lastInteraction = System.currentTimeMillis()
                                isBottomBarVisible = true
                            },
                        topBar = {
                            if (showFullUI) {
                                TopBar(topBarTitle, drawerState, scopeDrawer)
                            } else if (showSimpleTopBar) {
                                TopAppBar(
                                    title = { Text(topBarTitle, color = Color.White) },
                                    colors = TopAppBarDefaults.topAppBarColors(
                                        containerColor = colorResource(R.color.azul_petroleo)
                                    )
                                )
                            }
                        },
                        bottomBar = {
                            if (showFullUI) {
                                Box(modifier = Modifier.height(88.dp)) {
                                    AnimatedVisibility(
                                        visible = isBottomBarVisible,
                                        enter = slideInVertically { it } + fadeIn(),
                                        exit = slideOutVertically { it } + fadeOut()
                                    ) {
                                        BottomBar(
                                            selectedItem = currentScreen,
                                            navController = navController,
                                            onItemClick = { item ->
                                                currentScreen = item
                                                lastInteraction = System.currentTimeMillis()
                                                isBottomBarVisible = true
                                            }
                                        )
                                    }
                                }
                            }
                        }
                    ) { innerPadding ->
                        SportsHubGraph(
                            modifier = Modifier.padding(innerPadding),
                            navController = navController
                        )
                    }
                }
            }
        }
    }

    fun retrieveToken() {
        Firebase.messaging.token.addOnCompleteListener {
            if (it.isSuccessful) {
                val token = it.result
                Log.d("FCM", "Token: $token")
            }
        }
    }
}