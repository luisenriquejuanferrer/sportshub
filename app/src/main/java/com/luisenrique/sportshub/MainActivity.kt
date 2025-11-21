package com.luisenrique.sportshub

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ieschabas.sportshub.ui.screens.DashboardScreen
import com.ieschabas.sportshub.ui.screens.TeamDetailScreen
import com.luisenrique.sportshub.ui.components.BottomBar
import com.luisenrique.sportshub.ui.screens.ProfileScreen
import com.luisenrique.sportshub.ui.screens.TeamsListScreen
import com.luisenrique.sportshub.ui.theme.SportsHubTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SportsHubTheme {
                AppContent()
            }
        }
    }
}

@Composable
fun AppContent() {
    var currentScreen by remember { mutableStateOf("Inicio") }

    Scaffold(
        bottomBar = {
            BottomBar(
                selectedItem = currentScreen,
                onItemClick = { item -> currentScreen = item }
            )
        }
    ) { innerPadding ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            when (currentScreen) {
                "Inicio" -> DashboardScreen()
                "Ligas" -> {}
                "Partidos" -> {}
                "Perfil" -> ProfileScreen()
            }
        }
    }}