package com.luisenrique.sportshub

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ieschabas.sportshub.ui.screens.DashboardScreen
import com.ieschabas.sportshub.ui.screens.PlayerDetailsScreen
import com.ieschabas.sportshub.ui.screens.TeamDetailScreen
import com.luisenrique.sportshub.ui.components.BottomBar
import com.luisenrique.sportshub.ui.components.MainNavigationDrawer
import com.luisenrique.sportshub.ui.components.TopBar
import com.luisenrique.sportshub.ui.screens.ClasificationScreen
import com.luisenrique.sportshub.ui.screens.LeagueDetailScreen
import com.luisenrique.sportshub.ui.screens.LeagueListScreen
import com.luisenrique.sportshub.ui.screens.LoginRegisterScreen
import com.luisenrique.sportshub.ui.screens.MatchesScreen
import com.luisenrique.sportshub.ui.screens.ProfileScreen
import com.luisenrique.sportshub.ui.screens.TeamsListScreen
import com.luisenrique.sportshub.ui.theme.SportsHubTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            var currentScreen by remember { mutableStateOf("Inicio") }
            val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
            val scopeDrawer = rememberCoroutineScope()
            SportsHubTheme {
                MainNavigationDrawer(drawerState) {
                    Scaffold(
                        modifier = Modifier.fillMaxSize(),
                        topBar = {
                            TopBar("Sports Hub - IES Chabàs", drawerState, scopeDrawer)
                        },
                        bottomBar = {
            BottomBar(
                selectedItem = currentScreen,
                onItemClick = { item -> currentScreen = item }
            )

                    }
                    ) { innerPadding ->
                        // Luis
//                        LoginRegisterScreen(Modifier.padding(innerPadding))
//                        LeagueListScreen(Modifier.padding(innerPadding))
//                        LeagueDetailScreen(Modifier.padding(innerPadding))
//                        ClasificationScreen(Modifier.padding(innerPadding))
                        MatchesScreen(Modifier.padding(innerPadding))
                        // Christian
//                        ProfileScreen(Modifier.padding(innerPadding))
//                        TeamDetailScreen(Modifier.padding(innerPadding))
//                        DashboardScreen(Modifier.padding(innerPadding))
//                        TeamsListScreen(Modifier.padding(innerPadding))
//                        PlayerDetailsScreen(Modifier.padding(innerPadding))
                    }


            }
        }
    }
}}

//@Composable
//fun AppContent() {
//    var currentScreen by remember { mutableStateOf("Inicio") }
//
//    Scaffold(
//        bottomBar = {
//            BottomBar(
//                selectedItem = currentScreen,
//                onItemClick = { item -> currentScreen = item }
//            )
//        }
//    ) { innerPadding ->
//        Surface(
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(innerPadding)
//        ) {
//            when (currentScreen) {
//                "Inicio" -> DashboardScreen()
//                "Ligas" -> {}
//                "Partidos" -> {}
//                "Perfil" -> ProfileScreen()
//            }
//        }
//    }}