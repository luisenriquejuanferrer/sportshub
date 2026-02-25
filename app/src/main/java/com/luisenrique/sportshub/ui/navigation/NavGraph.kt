package com.luisenrique.sportshub.ui.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.luisenrique.sportshub.ui.screens.BetsScreen
import com.luisenrique.sportshub.ui.screens.DashboardScreen
import com.luisenrique.sportshub.ui.screens.classification.ClasificationScreen
import com.luisenrique.sportshub.ui.screens.leagues.LeagueDetailScreen
import com.luisenrique.sportshub.ui.screens.leagues.LeagueListScreen
import com.luisenrique.sportshub.ui.screens.loginregister.LoginRegisterScreen
import com.luisenrique.sportshub.ui.screens.loginregister.RegisterScreen
import com.luisenrique.sportshub.ui.screens.matches.MatchDetailScreen
import com.luisenrique.sportshub.ui.screens.matches.MatchesScreen
import com.luisenrique.sportshub.ui.screens.player.PlayerDetailsScreen
import com.luisenrique.sportshub.ui.screens.team.TeamDetailScreen
import com.luisenrique.sportshub.ui.screens.team.TeamsListScreen
import com.luisenrique.sportshub.ui.screens.user.ProfileScreen

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun SportsHubGraph(modifier: Modifier, navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Routes.LoginRegister,
        enterTransition = {
            slideInHorizontally(
                initialOffsetX = { it },
                animationSpec = tween(400)
            )
        },
        exitTransition = { fadeOut(animationSpec = tween(400)) },
        popEnterTransition = { fadeIn(animationSpec = tween(400)) },
        popExitTransition = {
            slideOutHorizontally(
                targetOffsetX = { it },
                animationSpec = tween(400)
            )
        }
    ) {
        composable(
            route = Routes.LoginRegister,
            enterTransition = { fadeIn(animationSpec = tween(500)) },
            popEnterTransition = { fadeIn(animationSpec = tween(500)) },
            popExitTransition = { fadeOut(animationSpec = tween(500)) }
        ) {
            LoginRegisterScreen(
                modifier = modifier,
                navController = navController
            )
        }

        composable(
            route = Routes.Register
        ) {
            RegisterScreen(
                modifier = modifier,
                navController = navController
            )
        }

        composable(
            route = Routes.Dashboard
        ) {
            DashboardScreen(
                modifier = modifier,
                navController = navController
            )
        }

        composable(
            route = Routes.Leagues
        ) {
            LeagueListScreen(
                modifier = modifier,
                navController = navController
            )
        }

        composable(
            route = Routes.Teams
        ) {
            TeamsListScreen(
                modifier = modifier,
                navController = navController
            )
        }

        composable(
            route = Routes.Matches,
            arguments = listOf(
                navArgument(
                    name = Routes.MatchesArg
                ) {
                    type = NavType.StringType
                    nullable = true
                }
            )) {
            MatchesScreen(
                modifier = modifier,
                navController = navController
            )
        }

        composable(
            route = Routes.MatchDetail,
            arguments = listOf(
                navArgument(
                    name = Routes.MatchDetailArg
                ) {
                    type = NavType.StringType
                    nullable = false
                }
            )) {
            MatchDetailScreen(
                modifier = modifier
            )
        }

        composable(
            route = Routes.Clasification,
            arguments = listOf(
                navArgument(
                    name = Routes.ClasificationArg
                ) {
                    type = NavType.StringType
                    nullable = true
                }
            )) {
            ClasificationScreen(
                modifier = modifier
            )
        }

        composable(
            route = Routes.LeagueDetail,
            arguments = listOf(
                navArgument(
                    name = Routes.LeagueDetailArg
                ) {
                    type = NavType.StringType
                    nullable = false
                }
            )) {
            LeagueDetailScreen(
                modifier = modifier,
                navController = navController
            )
        }

        composable(
            route = Routes.Bets
        ) {
            BetsScreen(
                modifier = modifier
            )
        }

        composable(
            route = Routes.Profile
        ) {
            ProfileScreen(
                modifier = modifier,
                navController = navController
            )
        }

        composable(
            route = Routes.TeamDetail,
            arguments = listOf(
                navArgument(
                    name = Routes.TeamDetailArg
                ) {
                    type = NavType.StringType
                    nullable = false
                }
            )
        ) {
            TeamDetailScreen(
                modifier = modifier,
                navController = navController
            )
        }

        composable(
            route = Routes.PlayerDetail,
            arguments = listOf(
                navArgument(
                    name = Routes.PlayerDetailArg
                ) {
                    type = NavType.StringType
                    nullable = false
                })
        ) {
            PlayerDetailsScreen(
                modifier = modifier
            )
        }
    }
}
