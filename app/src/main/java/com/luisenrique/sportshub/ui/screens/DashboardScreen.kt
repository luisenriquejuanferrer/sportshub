package com.luisenrique.sportshub.ui.screens


import android.Manifest
import android.os.Build
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.luisenrique.sportshub.ui.components.DashboardBox
import com.luisenrique.sportshub.ui.navigation.Routes


@Composable
fun DashboardScreen(modifier: Modifier, navController: NavController) {
    val context = LocalContext.current

    // Solo necesitamos pedir permiso en Android 13 (API 33) y superior
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        val launcher = rememberLauncherForActivityResult(
            contract = ActivityResultContracts.RequestPermission(),
            onResult = { isGranted ->
                if (isGranted) {
                    // Permiso concedido, puedes hacer algo si quieres (o simplemente dejarlo)
                    Log.d("FCM", "Permiso de notificaciones concedido")
                } else {
                    // Permiso denegado. Puedes mostrar un mensaje explicando por qué lo necesitas.
                    Log.d("FCM", "Permiso de notificaciones denegado")
                }
            }
        )

        LaunchedEffect(Unit) {
            launcher.launch(Manifest.permission.POST_NOTIFICATIONS)
        }
    }

    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(30.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,

                ) {
                DashboardBox(
                    "Ligas",
                    Color(0xFF4CAF50),
                    onClick = { navController.navigate(Routes.Leagues) })
                DashboardBox(
                    "Equipos",
                    Color(0xFF03A9F4),
                    onClick = { navController.navigate(Routes.Teams) })
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                DashboardBox(
                    "Partidos",
                    Color(0xFF49F527),
                    onClick = { navController.navigate(Routes.MatchesBase) })
                DashboardBox(
                    "Clasificación",
                    Color(0xFFED2600),
                    onClick = { navController.navigate(Routes.ClasificationBase) })
            }
        }
    }
}


