package com.luisenrique.sportshub.ui.screens.leagues

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.luisenrique.sportshub.R
import com.luisenrique.sportshub.ui.components.MyButton
import com.luisenrique.sportshub.ui.components.MyImage
import com.luisenrique.sportshub.ui.components.MyText
import com.luisenrique.sportshub.ui.navigation.Routes

@Composable
fun LeagueDetailScreen(
    modifier: Modifier,
    navController: NavController,
    viewModel: LeaguesViewModel = hiltViewModel()
) {
    val league by viewModel.league.collectAsStateWithLifecycle()

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        MyImage(
            painter = painterResource(R.drawable.brand_liga_ieschabas),
            contentDescription = "Logo liga chabàs",
            modifier = Modifier,
            alignment = Alignment.Center,
            contentScale = ContentScale.Fit
        )
        league?.let { currentLeague ->
            MyText(text = "Liga: ${currentLeague.name}")
            MyText(text = "País: ${currentLeague.country}")
            MyText(text = "Temporada: ${currentLeague.season}")

            Spacer(Modifier.height(16.dp))
            MyButton(
                onClick = { navController.navigate(Routes.createClasificationRoute(currentLeague.id)) },
                enabled = true,
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(R.color.azul_petroleo)
                ),
                text = "Ver clasificación"
            )
            MyButton(
                onClick = { navController.navigate(Routes.createMatchesRoute(currentLeague.id)) },
                enabled = true,
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF625b71)
                ),
                text = "Ver partidos"
            )
        } ?: run {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }
    }
}
