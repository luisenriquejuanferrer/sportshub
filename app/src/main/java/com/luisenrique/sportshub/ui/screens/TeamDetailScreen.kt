package com.ieschabas.sportshub.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.luisenrique.sportshub.R
import com.luisenrique.sportshub.ui.components.Jugador

@Composable
fun TeamDetailScreen(
    modifier: Modifier
) {

    val jugadores = listOf(
        Jugador(1, "Marcos Pérez", "Portero"),
        Jugador(2, "David García", "Defensa"),
        Jugador(3, "Sergio López", "Defensa"),
        Jugador(4, "Javier Martínez", "Centrocampista"),
        Jugador(5, "Pablo Sánchez", "Centrocampista"),
        Jugador(6, "Carlos Ruiz", "Centrocampista"),
        Jugador(7, "Antonio Jiménez", "Delantero"),
        Jugador(8, "Manuel Díaz", "Delantero"),
        Jugador(9, "Rubén Fernández", "Delantero"),
        Jugador(10, "Raúl Castro", "Centrocampista")
    )

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,

    ) {
        Card(
            modifier = Modifier
                .padding(start = 30.dp, top = 35.dp, end = 30.dp)
                .height(250.dp)
                .fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFF8C8C8C)
            ),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 20.dp
            )

        ) {
            Row(
                modifier = Modifier.padding(start = 16.dp, top = 65.dp, end = 16.dp),
                verticalAlignment = Alignment.CenterVertically,

            ) {
                Box(
                    modifier = Modifier
                        .size(80.dp)
                        .clip(RoundedCornerShape(50))
                        .background(Color(0xFFF0EBEB)),
                    contentAlignment = Alignment.Center
                ){
                    Image(
                        painter = painterResource(R.drawable.escudo_ies_chabas),
                        contentDescription = "Escudo Chabas",
                        modifier = Modifier.size(800.dp)
                    )

                }

                Spacer(modifier = Modifier.width(16.dp))

                Column (
                    modifier = Modifier
                        .padding(16.dp)
                ){
                    Text(text = "IES Chabàs", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.White)
                    Row(modifier = Modifier.padding(top = 8.dp),
                        verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            Icons.Filled.Person,
                            contentDescription = "Entrenador",
                            tint = Color.White
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(text = "Entrenador: A. Ortega", fontSize = 14.sp, color = Color.White)
                    }
                    Row(modifier = Modifier.padding(top = 8.dp),
                        verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            Icons.Filled.LocationOn,
                            contentDescription = "Ubicación",
                            tint = Color.White
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(text = "Campo Municipal", fontSize = 14.sp, color = Color.White)
                    }
                }
            }
        }


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .height(40.dp)
                    .background(
                        color = Color(0xFFF5F5F5),
                        shape = RoundedCornerShape(12.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text("Pts 27", color = Color.Black)
            }
            Box(
                modifier = Modifier
                    .weight(1f)
                    .height(40.dp)
                    .background(
                        color = Color(0xFFF5F5F5),
                        shape = RoundedCornerShape(12.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text("G 8", color = Color.Black)
            }
            Box(
                modifier = Modifier
                    .weight(1f)
                    .height(40.dp)
                    .background(
                        color = Color(0xFFF5F5F5),
                        shape = RoundedCornerShape(12.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text("E 3", color = Color.Black)
            }
            Box(
                modifier = Modifier
                    .weight(1f)
                    .height(40.dp)
                    .background(
                        color = Color(0xFFF5F5F5),
                        shape = RoundedCornerShape(12.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text("P 2", color = Color.Black)
            }
        }


        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .background(Color(0xFFF5F5F5))

        ) {
            Column {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        Icons.Filled.Person,
                        contentDescription = "Entrenador",
                        tint = Color.Black
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Column {
                        Text(text = "Entrenador", fontSize = 12.sp)
                        Text(text = "A. Ortega", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                    }

                }
                Spacer(modifier = Modifier.height(8.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        Icons.Filled.LocationOn,
                        contentDescription = "Estadio",
                        tint = Color.Black
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Column {
                        Text(text = "Estadio", fontSize = 12.sp)
                        Text(text = "Campo Municipal", fontSize = 16.sp)
                    }

                }
                Spacer(modifier = Modifier.height(8.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        Icons.Filled.DateRange,
                        contentDescription = "Fundado",
                        tint = Color.Black
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Column {
                        Text(text = "Fundado", fontSize = 12.sp)
                        Text(text = "2004", fontSize = 16.sp)
                    }

                }
            }
        }


        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Plantilla",
            modifier = Modifier.padding(start = 16.dp),
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(8.dp))

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            items(jugadores) { jugador ->
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xFFF5F5F5), shape = androidx.compose.material3.MaterialTheme.shapes.medium)
                        .padding(12.dp),
                    contentAlignment = Alignment.CenterStart
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = "⚽",
                            fontSize = 24.sp,
                            color = Color(0xFF9C27B0)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Column {
                            Text(
                                text = "${jugador.dorsal} - ${jugador.nombre}",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = jugador.posicion,
                                fontSize = 14.sp,
                                color = Color.Gray
                            )
                        }
                    }
                }
            }
        }
    }
}

