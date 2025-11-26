package com.luisenrique.sportshub.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.luisenrique.sportshub.R
import com.luisenrique.sportshub.ui.components.MyButton
import com.luisenrique.sportshub.ui.components.MyImage
import com.luisenrique.sportshub.ui.components.MyText
import com.luisenrique.sportshub.ui.navigation.Routes

@Composable
fun LeagueDetailScreen(modifier: Modifier, navController: NavController) {
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
        MyText(text = "Liga: LaLiga")
        MyText(text = "Caracteristicas de la liga (Lorem Ipsum)")
        Spacer(Modifier.padding(vertical = 8.dp))
        MyButton(
            onClick = { navController.navigate(Routes.Clasification) },
            enabled = true,
            modifier = Modifier,
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(R.color.azul_petroleo)
            ),
            text = "Ver clasificación"
        )
        MyButton(
            onClick = { navController.navigate(Routes.Matches) },
            enabled = true,
            modifier = Modifier,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF625b71)
            ),
            text = "Ver partidos"
        )
    }
}