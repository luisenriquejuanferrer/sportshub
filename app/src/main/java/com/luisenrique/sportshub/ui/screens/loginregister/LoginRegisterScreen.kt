package com.luisenrique.sportshub.ui.screens.loginregister

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavController
import com.luisenrique.sportshub.R
import com.luisenrique.sportshub.ui.components.MyButton
import com.luisenrique.sportshub.ui.components.MyImage
import com.luisenrique.sportshub.ui.components.MySwitch
import com.luisenrique.sportshub.ui.components.MyText
import com.luisenrique.sportshub.ui.components.MyTextField
import com.luisenrique.sportshub.ui.navigation.Routes
import com.luisenrique.sportshub.ui.utils.Resource

@Composable
fun LoginRegisterScreen(
    modifier: Modifier,
    viewModel: LoginViewModel = hiltViewModel(),
    navController: NavController
) {
    var checked by remember { mutableStateOf(true) }

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val loginState by viewModel.loginFlow.collectAsState(initial = null)
    val context = LocalContext.current

    LaunchedEffect(loginState) {
        when (loginState) {
            is Resource.Success -> {
                Toast.makeText(context, "¡Bienvenido Madurito!", Toast.LENGTH_SHORT).show()
            }

            is Resource.Error -> {
                val err = (loginState as Resource.Error).exception
                Toast.makeText(context, "Email o contraseña incorrectos.", Toast.LENGTH_LONG).show()
            }

            is Resource.Loading -> {
                // Opcional: Mostrar log en consola
            }

            null -> {}
        }
    }

    Column(
        modifier = modifier
            .padding(16.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MyImage(
            painter = painterResource(R.drawable.logo_chabas),
            contentDescription = "Logo Chabàs",
            modifier = Modifier.size(260.dp),
            alignment = Alignment.Center,
            contentScale = ContentScale.Fit
        )
        Spacer(Modifier.padding(vertical = 8.dp))
        TextField(
            value = email,
            onValueChange = { email = it },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    border = BorderStroke(1.dp, Color.DarkGray),
                    shape = RoundedCornerShape(4.dp)
                )
        )
        Spacer(Modifier.padding(vertical = 8.dp))
        TextField(
            value = password,
            onValueChange = { password = it },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    border = BorderStroke(1.dp, Color.DarkGray),
                    shape = RoundedCornerShape(4.dp)
                )
        )
        Spacer(Modifier.padding(vertical = 8.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            MySwitch(
                checked,
                onCheckedChange = { checked = it },
                colors = SwitchDefaults.colors(
                    checkedTrackColor = colorResource(id = R.color.azul_petroleo)
                )
            )
            Spacer(Modifier.padding(horizontal = 4.dp))
            MyText(text = "Recordarme")
        }
        Spacer(Modifier.padding(vertical = 8.dp))
        Button(
            onClick = { viewModel.login(email, password) },
            enabled = loginState !is Resource.Loading,
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(R.color.azul_petroleo)
            )
        ) {
            Text("Login")
            //navController.navigate(Routes.Dashboard)
        }

        Spacer(Modifier.padding(vertical = 8.dp))
        Row(modifier = Modifier.fillMaxWidth()) {
            MyText(
                text = "¿No tienes cuenta?",
                modifier = Modifier.padding(end = 4.dp)
            )
            Text(
                "Registrate",
                modifier = Modifier.clickable { navController.navigate(Routes.Register) },
                color = Color.Blue,
                fontStyle = FontStyle.Italic,
                textDecoration = TextDecoration.Underline
            )
        }
    }
}