package com.luisenrique.sportshub

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.luisenrique.sportshub.ui.components.MainNavigationDrawer
import com.luisenrique.sportshub.ui.components.TopBar
import com.luisenrique.sportshub.ui.screens.ClasificationScreen
import com.luisenrique.sportshub.ui.screens.LeagueDetailScreen
import com.luisenrique.sportshub.ui.screens.LeagueListScreen
import com.luisenrique.sportshub.ui.screens.LoginRegisterScreen
import com.luisenrique.sportshub.ui.screens.MatchesScreen
import com.luisenrique.sportshub.ui.theme.SportsHubTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val drawerState = rememberDrawerState(DrawerValue.Closed)
            val scopeDrawer = rememberCoroutineScope()

            SportsHubTheme {
                MainNavigationDrawer(drawerState) {
                    Scaffold(
                        modifier = Modifier.fillMaxSize(),
                        topBar = {
                            TopBar("Sports Hub - IES Chabàs", drawerState, scopeDrawer)
                        }
                    ) { innerPadding ->
                        // Luis
//                        LoginRegisterScreen(Modifier.padding(innerPadding))
//                        LeagueListScreen(Modifier.padding(innerPadding))
//                        LeagueDetailScreen(Modifier.padding(innerPadding))
                        ClasificationScreen(Modifier.padding(innerPadding))
//                        MatchesScreen(Modifier.padding(innerPadding))
                        // Christian
//                        ProfileScreen(Modifier.padding(innerPadding))
//                        TeamDetailScreen(Modifier.padding(innerPadding))
//                        DashboardScreen(Modifier.padding(innerPadding))
//                        TeamsListScreen(Modifier.padding(innerPadding))
                    }
                }
            }
        }
    }
}