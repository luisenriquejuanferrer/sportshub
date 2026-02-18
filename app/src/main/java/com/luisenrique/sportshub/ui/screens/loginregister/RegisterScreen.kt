package com.luisenrique.sportshub.ui.screens.loginregister

import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.luisenrique.sportshub.R
import com.luisenrique.sportshub.ui.components.MyButton
import com.luisenrique.sportshub.ui.components.MyCheckBox
import com.luisenrique.sportshub.ui.components.MyOutlinedTextField
import com.luisenrique.sportshub.ui.components.MyText
import com.luisenrique.sportshub.ui.navigation.Routes

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun RegisterScreen(
    modifier: Modifier,
    navController: NavController,
    viewModel: RegisterViewModel = hiltViewModel()
) {
    val sexo = listOf("Masculino", "Femenino", "Otro")
    val state by viewModel.state.collectAsState()

    LaunchedEffect(state.registrationSuccess) {
        if (state.registrationSuccess) {
            navController.navigate(Routes.LoginRegister) {
                popUpTo(Routes.Register) { inclusive = true }
            }
        }
    }

    if (state.errorMessage != null) {
        Toast.makeText(LocalContext.current, state.errorMessage, Toast.LENGTH_LONG).show()
    }

    Column(
        modifier = modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        MyText(text = "Usuario", fontSize = 14.sp, fontWeight = FontWeight.Bold)
        MyOutlinedTextField(
            value = state.userName,
            onValueChange = { viewModel.onUserNameChange(it) },
            placeHolder = "",
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.padding(8.dp))
        MyText(text = "Nombre y apellidos", fontSize = 14.sp, fontWeight = FontWeight.Bold)
        MyOutlinedTextField(
            value = state.fullName,
            onValueChange = { viewModel.onFullNameChange(it) },
            placeHolder = "",
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.padding(8.dp))
        MyText(text = "Sexo", fontSize = 14.sp, fontWeight = FontWeight.Bold)
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            sexo.forEach { text ->
                Row(
                    Modifier
                        .selectable(
                            selected = (text == state.sex),
                            onClick = { viewModel.onSexChange(text) },
                            role = Role.RadioButton
                        ),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = (text == state.sex),
                        onClick = { viewModel.onSexChange(text) }
                    )
                    Spacer(Modifier.padding(start = 4.dp))
                    MyText(text = text, fontSize = 14.sp)
                }
            }
        }

        Spacer(Modifier.padding(8.dp))
        MyText(text = "Email", fontSize = 14.sp, fontWeight = FontWeight.Bold)
        MyOutlinedTextField(
            value = state.email,
            onValueChange = { viewModel.onEmailChange(it) },
            placeHolder = "",
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.padding(8.dp))
        MyText(text = "Contraseña", fontSize = 14.sp, fontWeight = FontWeight.Bold)
        MyOutlinedTextField(
            value = state.password,
            onValueChange = { viewModel.onPasswordChange(it) },
            placeHolder = "",
            modifier = Modifier.fillMaxWidth()
        )

        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            MyCheckBox()
            MyText("He leído y acepto la política de privacidad", fontSize = 12.sp)
        }

        Spacer(Modifier.height(8.dp))
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            MyButton(
                onClick = { viewModel.onRegisterClick() },
                enabled = !state.isLoading,
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(R.color.azul_petroleo)
                ),
                text = if (state.isLoading) "Registrando..." else "Registrar",
            )
        }
    }
}
