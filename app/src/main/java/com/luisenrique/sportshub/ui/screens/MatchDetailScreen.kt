package com.luisenrique.sportshub.ui.screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavController
import com.luisenrique.sportshub.R
import com.luisenrique.sportshub.domain.model.PartidoDetalle
import com.luisenrique.sportshub.ui.components.MyImage
import com.luisenrique.sportshub.ui.components.MyText
import com.luisenrique.sportshub.ui.screens.matches.MatchDetailViewModel
import com.luisenrique.sportshub.ui.utils.formatUtcDate

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MatchDetailScreen(
    modifier: Modifier,
    viewModel: MatchDetailViewModel = hiltViewModel()
) {
//    val partidoDetalle = PartidoDetalle(
//        "Sáb 20:47",
//        "IES Chabàs",
//        "Maria Ivars",
//        "2 - 1",
//        "El Rodat",
//        "Dénia",
//        55,
//        45,
//        7,
//        4
//    )

    val match by viewModel.state.collectAsState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        MyText(
            text = "Resultado",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
        HorizontalDivider(Modifier.padding(vertical = 16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            MyImage(
                painter = painterResource(R.drawable.escudo_ies_chabas),
                contentDescription = "Escudo local",
                modifier = Modifier
                    .size(64.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                MyText(
                    text = "${match?.homeScore ?: "0"} - ${match?.awayScore ?: "0"}",
                    fontSize = 32.sp,
                    textAlign = androidx.compose.ui.text.style.TextAlign.Center
                )
                MyText(
                    text = "${match?.homeTeam?.name} vs ${match?.awayTeam?.name}",
                    fontSize = 14.sp,
                    textAlign = androidx.compose.ui.text.style.TextAlign.Center
                )
            }

            MyImage(
                painter = painterResource(R.drawable.escudo_maria_ivars),
                contentDescription = "Escudo visitante",
                modifier = Modifier
                    .size(64.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )
        }

        Spacer(Modifier.height(16.dp))

        MyText("Fecha: ${formatUtcDate(match?.dateUtc)}", fontSize = 16.sp)

        Spacer(Modifier.height(24.dp))

        MyText("Estadio: ${match?.homeTeam?.city}", fontSize = 16.sp)
        MyText("Ciudad: ${match?.homeTeam?.city}", fontSize = 16.sp)
        Spacer(Modifier.height(24.dp))

        MyText("Estadísticas", fontSize = 20.sp)

        Spacer(Modifier.height(8.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 6.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            //MyText("${partidoDetalle.posesionLocal}%", fontSize = 16.sp)
            MyText("Posesión", fontSize = 16.sp)
            //MyText("${partidoDetalle.posesionVisitante}%", fontSize = 16.sp)
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 6.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            //MyText("${partidoDetalle.tirosLocal}", fontSize = 16.sp)
            MyText("Tiros", fontSize = 16.sp)
            //MyText("${partidoDetalle.tirosVisitante}", fontSize = 16.sp)
        }

        Spacer(Modifier.height(24.dp))
    }
}