package com.luisenrique.sportshub.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.luisenrique.sportshub.R
import com.luisenrique.sportshub.domain.model.Classification

@Composable
fun ClasificationTeamItem(
    posicion: Int,
    classification: Classification
) {
    val textColor = if (posicion < 4) Color.Magenta else Color.Unspecified

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        MyImage(
            painter = painterResource(R.drawable.escudo_ies_chabas),
            contentDescription = "Logo equipo",
            modifier = Modifier
                .size(32.dp)
                .clip(CircleShape)
                .weight(1f),
            alignment = Alignment.CenterStart,
            contentScale = ContentScale.Fit
        )

        MyText(
            text = classification.clubId,
            color = textColor,
            modifier = Modifier.weight(2f)
        )
        MyText(
            text = classification.gamesPlayed.toString(),
            color = textColor,
            modifier = Modifier.weight(1f)
        )
        MyText(
            text = classification.victories.toString(),
            color = textColor,
            modifier = Modifier.weight(1f)
        )
        MyText(
            text = classification.ties.toString(),
            color = textColor,
            modifier = Modifier.weight(1f)
        )
        MyText(
            text = classification.lost.toString(),
            color = textColor,
            modifier = Modifier.weight(1f)
        )
        MyText(
            text = classification.totalPoints.toString(),
            color = textColor,
            modifier = Modifier.weight(1f)
        )
    }
}
