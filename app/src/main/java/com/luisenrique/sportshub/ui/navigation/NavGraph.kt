package com.ieschabas.navigationcompose.navigation

import BetsScreen
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.ieschabas.sportshub.ui.screens.DashboardScreen
import com.ieschabas.sportshub.ui.screens.PlayerDetailsScreen
import com.ieschabas.sportshub.ui.screens.TeamDetailScreen
import com.luisenrique.sportshub.ui.screens.ClasificationScreen
import com.luisenrique.sportshub.ui.screens.LeagueDetailScreen
import com.luisenrique.sportshub.ui.screens.LeagueListScreen
import com.luisenrique.sportshub.ui.screens.LoginRegisterScreen
import com.luisenrique.sportshub.ui.screens.MatchDetailScreen
import com.luisenrique.sportshub.ui.screens.MatchesScreen
import com.luisenrique.sportshub.ui.screens.ProfileScreen
import com.luisenrique.sportshub.ui.screens.RegisterScreen
import com.luisenrique.sportshub.ui.screens.TeamsListScreen
import kotlinx.serialization.decodeFromString


@Composable
fun SportsHubGraph(modifier: Modifier, navController : NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "login"
    ) {
        composable(route = "login") {
            LoginRegisterScreen(modifier = modifier, navController = navController)
        }
        composable(route = "dashboard") {
            DashboardScreen(modifier = modifier, navController = navController)
        }
        composable(route = "ligas") {
            LeagueListScreen(modifier = modifier, navController = navController)
        }
        composable(route = "equipos") {
            TeamsListScreen(modifier = modifier, navController = navController)
        }
        composable(route = "partidos") {
            MatchesScreen(modifier = modifier, navController = navController)
        }
        composable(route = "clasificacion") {
            ClasificationScreen(modifier = modifier, navController = navController)
        }
        composable(route = "ligaDetails") {
            LeagueDetailScreen(modifier = modifier, navController = navController)
        }
        composable(route = "apuestas") {
            BetsScreen(modifier = modifier)
        }
        composable(route = "perfil") {
            ProfileScreen(modifier = modifier, navController = navController)
        }

        composable(route = "partido") {
            MatchDetailScreen(modifier = modifier)
        }

        composable(route = "detallesEquipo") {
            TeamDetailScreen(modifier = modifier, navController = navController)

        }
        composable (route = "detallesJugador"){
            PlayerDetailsScreen(modifier = modifier)
        }

        composable(route = "registro") {
            RegisterScreen(modifier = modifier)
        }
    }
}