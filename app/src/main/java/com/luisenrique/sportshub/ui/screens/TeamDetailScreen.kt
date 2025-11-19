package com.ieschabas.sportshub.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.luisenrique.sportshub.R
import com.luisenrique.sportshub.ui.screens.Jugador

@Composable
fun TeamDetailScreen() {

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
        modifier = Modifier.fillMaxSize()
    ) {



        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(160.dp)
                .background(
                    brush = androidx.compose.ui.graphics.Brush.linearGradient(
                        listOf(
                            Color(0xFFBDBDBD),
                            Color(0xFF9E9E9E)
                        )
                    )
                ),

        ) {
            Row(
                modifier = Modifier.padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.escudo_ies_chabas),
                    contentDescription = "Escudo IES Chabàs",
                    modifier = Modifier.size(80.dp)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Column {
                    Text(text = "IES Chabàs", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            Icons.Filled.Person,
                            contentDescription = "Entrenador",
                            tint = Color.Black
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(text = "Entrenador: A. Ortega", fontSize = 14.sp)
                    }
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            Icons.Filled.LocationOn,
                            contentDescription = "Ubicación",
                            tint = Color.Black
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(text = "Campo Municipal", fontSize = 14.sp)
                    }
                }
            }
        }

        // Estadísticas
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = { },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF5F5F5)),
                shape = androidx.compose.material3.MaterialTheme.shapes.medium
            ) {
                Text("Pts 27", color = Color.Black)
            }
            Button(
                onClick = { },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF5F5F5)),
                shape = androidx.compose.material3.MaterialTheme.shapes.medium
            ) {
                Text("G 8", color = Color.Black)
            }
            Button(
                onClick = { },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF5F5F5)),
                shape = androidx.compose.material3.MaterialTheme.shapes.medium
            ) {
                Text("E 3", color = Color.Black)
            }
            Button(
                onClick = { },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF5F5F5)),
                shape = androidx.compose.material3.MaterialTheme.shapes.medium
            ) {
                Text("P 2", color = Color.Black)
            }
        }

        // Info adicional
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .background(Color(0xFFF5F5F5), shape = androidx.compose.material3.MaterialTheme.shapes.medium)
                .padding(16.dp)
        ) {
            Column {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        Icons.Filled.Person,
                        contentDescription = "Entrenador",
                        tint = Color.Black
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = "A. Ortega", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                }
                Spacer(modifier = Modifier.height(8.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        Icons.Filled.LocationOn,
                        contentDescription = "Estadio",
                        tint = Color.Black
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = "Campo Municipal", fontSize = 16.sp)
                }
                Spacer(modifier = Modifier.height(8.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        Icons.Filled.DateRange,
                        contentDescription = "Fundado",
                        tint = Color.Black
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = "Fundado 2004", fontSize = 16.sp)
                }
            }
        }

        // Plantilla
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
                        Icon(
                            Icons.Filled.Person,
                            contentDescription = "Jugador",
                            tint = Color(0xFF9C27B0)
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