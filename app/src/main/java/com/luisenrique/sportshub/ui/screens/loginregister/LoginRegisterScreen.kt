package com.luisenrique.sportshub.ui.screens.loginregister

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
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
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavController
import com.luisenrique.sportshub.R
import com.luisenrique.sportshub.ui.components.MyImage
import com.luisenrique.sportshub.ui.components.MySwitch
import com.luisenrique.sportshub.ui.components.MyText
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
    var isPasswordVisible by remember { mutableStateOf(false) }

    val loginState by viewModel.loginFlow.collectAsState(initial = null)
    val context = LocalContext.current

    LaunchedEffect(loginState) {
        when (loginState) {
            is Resource.Success -> {
                Toast.makeText(context, "¡Bienvenido!", Toast.LENGTH_SHORT).show()
                navController.navigate(Routes.Dashboard)
            }

            is Resource.Error -> {
                val err = (loginState as Resource.Error).exception
                Toast.makeText(context, "Email o contraseña incorrectos.", Toast.LENGTH_LONG).show()
            }

            is Resource.Loading -> {
            }

            null -> {}
        }
    }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MyImage(
            painter = painterResource(R.drawable.logo_chabas),
            contentDescription = "Logo Chabàs",
            modifier = Modifier
                .fillMaxWidth()
                .height(240.dp),
            alignment = Alignment.Center,
            contentScale = ContentScale.Fit
        )
        Spacer(Modifier.padding(vertical = 8.dp))

        TextField(
            value = email,
            onValueChange = { email = it },
            placeholder = {
                Text(text = "Email")
            },
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
            placeholder = {
                Text(text = "Contraseña")
            },
            visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                val image = if (isPasswordVisible)
                    painterResource(R.drawable.baseline_visibility_24)
                else
                    painterResource(R.drawable.baseline_visibility_off_24)

                val description = if (isPasswordVisible) "Hide password" else "Show password"

                Icon(
                    painter = image,
                    contentDescription = description,
                    tint = Color.DarkGray,
                    modifier = Modifier.clickable { isPasswordVisible = !isPasswordVisible }
                )
            },
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
