

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.luisenrique.sportshub.ui.navigation.Routes
import com.luisenrique.sportshub.ui.screens.user.UserViewModel

@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: UserViewModel = hiltViewModel()
) {
    val users by viewModel.users.collectAsStateWithLifecycle()
    val user = users.firstOrNull()

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(top = 30.dp, start = 16.dp, end = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Box(
            modifier = Modifier
                .size(80.dp)
                .clip(RoundedCornerShape(50))
                .background(Color(0xFFC4C4C4)),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = "Icono de Perfil",
                tint = Color.Magenta,
                modifier = Modifier.size(80.dp)
            )
        }

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFF5F5F5))
                .padding(top = 16.dp)
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {

                if (user != null) {
                    Text(
                        text = "Nombre: ${user.fullName}",
                        modifier = Modifier.padding(top = 10.dp, start = 16.dp),
                        fontSize = 16.sp
                    )
                    Text(
                        text = "Usuario: @${user.userName.lowercase()}",
                        modifier = Modifier.padding(top = 4.dp, start = 16.dp),
                        fontSize = 16.sp
                    )
                    Text(
                        text = "Email: ${user.email}",
                        modifier = Modifier.padding(top = 4.dp, start = 16.dp),
                        fontSize = 16.sp
                    )
                    Text(
                        text = "Miembro desde: ${user.memberSince}",
                        modifier = Modifier.padding(top = 4.dp, start = 16.dp),
                        fontSize = 16.sp
                    )

                    Row(
                        modifier = Modifier.padding(16.dp),
                    ) {
                        Box(
                            modifier = Modifier
                                .width(100.dp)
                                .height(35.dp)
                                .clip(RoundedCornerShape(10.dp))
                                .background(Color(0xFFF5F5F5))
                                .border(
                                    width = 1.dp,
                                    color = Color.Black,
                                    shape = RoundedCornerShape(10.dp)
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = if (user.verified) "Verificado" else "No verificado",
                                color = if (user.verified) Color(0xFF4CAF50) else Color.Red,
                                fontSize = 16.sp
                            )
                        }
                    }
                } else {
                    Text(
                        text = "Cargando perfil...",
                        modifier = Modifier.padding(16.dp),
                        fontSize = 16.sp
                    )
                }
            }
        }

        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text("Zona de peligro", fontSize = 20.sp, color = Color.Red)
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            OutlinedButton(
                onClick = { navController.navigate(Routes.LoginRegister) }
            ) {
                Text(text = "Cerrar Sesión", fontSize = 16.sp, color = Color.Red)
            }
        }
    }
}
