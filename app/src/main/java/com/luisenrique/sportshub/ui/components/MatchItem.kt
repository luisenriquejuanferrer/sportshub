package com.luisenrique.sportshub.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.luisenrique.sportshub.R
import com.luisenrique.sportshub.ui.screens.Partido

@Composable
fun MatchItem(partido: Partido) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Column {
            MyText(text = partido.fecha)
            Spacer(Modifier.padding(vertical = 8.dp))
            Row {
                MyImage(
                    painter = painterResource(R.drawable.escudo_ies_chabas),
                    contentDescription = "Logo equipo",
                    modifier = Modifier
                        .size(26.dp)
                        .clip(CircleShape),
                    alignment = Alignment.CenterStart,
                    contentScale = ContentScale.Crop
                )
                Spacer(Modifier.padding(horizontal = 4.dp))
                MyText(text = partido.local, fontSize = 24.sp)
            }
            Spacer(Modifier.padding(vertical = 8.dp))
            Row {
                MyImage(
                    painter = painterResource(R.drawable.escudo_maria_ivars),
                    contentDescription = "Logo equipo",
                    modifier = Modifier
                        .size(26.dp)
                        .clip(CircleShape),
                    alignment = Alignment.CenterStart,
                    contentScale = ContentScale.Crop
                )
                Spacer(Modifier.padding(horizontal = 4.dp))
                MyText(text = partido.visitante, fontSize = 24.sp)
            }
        }
        Spacer(modifier = Modifier.weight(1f))
        Box(
            modifier = Modifier
                .border(1.dp, Color.DarkGray, RoundedCornerShape(8.dp))
        ) {
            MyText(
                text = partido.resultado,
                textAlign = TextAlign.End,
                modifier = Modifier.padding(16.dp, 4.dp)
            )
        }
    }
}