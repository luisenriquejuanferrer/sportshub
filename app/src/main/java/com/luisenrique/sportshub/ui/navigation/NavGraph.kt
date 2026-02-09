package com.ieschabas.navigationcompose.navigation

import BetsScreen
import ProfileScreen
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.ieschabas.sportshub.ui.screens.DashboardScreen
import com.luisenrique.sportshub.ui.navigation.Routes
import com.luisenrique.sportshub.ui.screens.LoginRegisterScreen
import com.luisenrique.sportshub.ui.screens.RegisterScreen
import com.luisenrique.sportshub.ui.screens.classification.ClasificationScreen
import com.luisenrique.sportshub.ui.screens.leagues.LeagueDetailScreen
import com.luisenrique.sportshub.ui.screens.leagues.LeagueListScreen
import com.luisenrique.sportshub.ui.screens.matches.MatchDetailScreen
import com.luisenrique.sportshub.ui.screens.matches.MatchesScreen
import com.luisenrique.sportshub.ui.screens.player.PlayerDetailsScreen
import com.luisenrique.sportshub.ui.screens.team.TeamDetailScreen
import com.luisenrique.sportshub.ui.screens.team.TeamsListScreen


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun SportsHubGraph(modifier: Modifier, navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Routes.LoginRegister
    ) {
        composable(route = Routes.LoginRegister) {
            LoginRegisterScreen(modifier = modifier, navController = navController)
        }
        composable(route = Routes.Register) {
            RegisterScreen(modifier = modifier, navController = navController)
        }
        composable(route = Routes.Dashboard) {
            DashboardScreen(modifier = modifier, navController = navController)
        }
        composable(route = Routes.Leagues) {
            LeagueListScreen(modifier = modifier, navController = navController)
        }
        composable(route = Routes.Teams) {
            TeamsListScreen(modifier = modifier, navController = navController)
        }
        composable(route = Routes.Matches) {
            MatchesScreen(
                modifier = modifier,
                navController = navController,
                onMatchClick = { matchId ->
                    navController.navigate(Routes.createMatchDetailRoute(matchId))
                })
        }
        composable(
            route = Routes.MatchDetail,
            arguments = listOf(
                navArgument(name = Routes.MatchDetailArg) {
                    type = NavType.StringType
                    nullable = false
                }
            )) {
            MatchDetailScreen(modifier = modifier)
        }
        composable(route = Routes.Clasification) {
            ClasificationScreen(modifier = modifier, navController = navController)
        }
        composable(route = Routes.LeagueDetail,
            arguments = listOf(
                navArgument(name = Routes.LeagueDetailArg) {
                    type = NavType.StringType
                    nullable = false
                }
            )) {
            LeagueDetailScreen(modifier = modifier, navController = navController)
        }
        composable(route = Routes.Bets) {
            BetsScreen(modifier = modifier)
        }
        composable(route = Routes.Profile) {
            ProfileScreen(modifier = modifier, navController = navController)
        }
        composable(route = Routes.TeamDetail + "/{teamId}") { // Ruta con parametro
            TeamDetailScreen(modifier = modifier, navController = navController)
        }
        composable(
            route = Routes.PlayerDetail + "/{playerId}", // Ruta con parametro
            arguments = listOf(navArgument("playerId") { type = NavType.StringType }) // Definimos el argumento
        ) {
            PlayerDetailsScreen(modifier = modifier, navController = navController)
        }
    }
}