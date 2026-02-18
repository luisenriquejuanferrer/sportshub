package com.luisenrique.sportshub.ui.screens.loginregister

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.luisenrique.sportshub.domain.model.User
import com.luisenrique.sportshub.domain.repository.AuthRepository
import com.luisenrique.sportshub.domain.repository.UserRepository
import com.luisenrique.sportshub.ui.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.time.LocalDate
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val authRepository: AuthRepository,
    private val userRepository: UserRepository
) : ViewModel() {

    private val _state = MutableStateFlow(RegisterState())
    val state: StateFlow<RegisterState> = _state

    fun onUserNameChange(userName: String) {
        _state.update { it.copy(userName = userName) }
    }

    fun onFullNameChange(fullName: String) {
        _state.update { it.copy(fullName = fullName) }
    }

    fun onEmailChange(email: String) {
        _state.update { it.copy(email = email) }
    }

    fun onPasswordChange(password: String) {
        _state.update { it.copy(password = password) }
    }

    fun onSexChange(text: String) {
        _state.update { it.copy(sex = text) }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun onRegisterClick() = viewModelScope.launch {
        _state.update { it.copy(isLoading = true, errorMessage = null) }

        val currentState = _state.value

        // 1. Validaciones
        if (currentState.email.isBlank() || currentState.password.isBlank() || currentState.userName.isBlank()) {
            _state.update {
                it.copy(
                    isLoading = false,
                    errorMessage = "Rellena todos los campos obligatorios"
                )
            }
            return@launch
        }

        // 2. Crear el modelo PRELIMINAR (con ID vacío)
        // Nota: memberSince lo generamos aquí con LocalDate
        val userToCreate = User(
            id = "", // El repositorio lo rellenará con el UID real de Firebase
            userName = currentState.userName,
            fullName = currentState.fullName,
            email = currentState.email,
            sex = currentState.sex,
            memberSince = LocalDate.now().toString(), // "2023-10-27"
            verified = false // Por defecto false
        )

        // 3. Llamar al repositorio enviando la password por separado
        val result = authRepository.register(
            email = currentState.email,
            password = currentState.password,
            user = userToCreate
        )

        when (result) {
            is Resource.Success -> {
                _state.update { it.copy(isLoading = false, registrationSuccess = true) }
            }

            is Resource.Error -> {
                _state.update {
                    it.copy(
                        isLoading = false,
                        errorMessage = result.exception.message
                    )
                }
            }

            else -> {} // Loading
        }
    }
}

data class RegisterState(
    val userName: String = "",
    val fullName: String = "",
    val email: String = "",
    val password: String = "",
    val sex: String = "Masculino",
    val registrationSuccess: Boolean = false,
    val isLoading: Boolean = false,
    val errorMessage: String? = null
)

