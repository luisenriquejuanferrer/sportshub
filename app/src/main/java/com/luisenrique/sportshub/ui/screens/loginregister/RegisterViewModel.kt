package com.luisenrique.sportshub.ui.screens.loginregister

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.luisenrique.sportshub.domain.model.User
import com.luisenrique.sportshub.domain.repository.AuthRepository
import com.luisenrique.sportshub.domain.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
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

    private val _uiState = MutableStateFlow(RegisterUiState())
    val uiState = _uiState.asStateFlow()

    fun onUserNameChange(userName: String) {
        _uiState.update { it.copy(userName = userName) }
    }

    fun onFullNameChange(fullName: String) {
        _uiState.update { it.copy(fullName = fullName) }
    }

    fun onEmailChange(email: String) {
        _uiState.update { it.copy(email = email) }
    }

    fun onPasswordChange(password: String) {
        _uiState.update { it.copy(password = password) }
    }

    fun onRegisterClick() {
        val state = uiState.value

        if (state.userName.isBlank() || state.fullName.isBlank() || state.email.isBlank() || state.password.length < 6) {
            _uiState.update {
                it.copy(errorMessage = "Por favor, rellena todos los campos. La contraseña debe tener al menos 6 caracteres.")
            }
            return
        }

        viewModelScope.launch {
            try {

                _uiState.update { it.copy(isLoading = true, errorMessage = null) }


                val authResult = authRepository.createUser(state.email, state.password)
                val firebaseUser = authResult.user
                    ?: throw IllegalStateException("Firebase no devolvió un usuario después del registro.") // Verificación extra


                val user = User(
                    id = firebaseUser.uid,
                    fullName = state.fullName.trim(),
                    userName = state.userName.trim(),
                    email = state.email.trim(),
                    memberSince = LocalDate.now().toString(),
                    verified = firebaseUser.isEmailVerified
                )
                userRepository.registerUser(user)


                _uiState.update { it.copy(isLoading = false, registrationSuccess = true) }

            } catch (e: Exception) {

                val errorMessage = when (e) {
                    is com.google.firebase.auth.FirebaseAuthUserCollisionException -> "El correo electrónico ya está en uso por otra cuenta."
                    is com.google.firebase.auth.FirebaseAuthWeakPasswordException -> "La contraseña es demasiado débil."
                    else -> "Error en el registro: ${e.message}"
                }
                _uiState.update {
                    it.copy(isLoading = false, errorMessage = errorMessage)
                }
            }
        }
    }

    // No es necesario modificar el UiState, está bien como está.
    data class RegisterUiState(
        val userName: String = "",
        val password: String = "",
        val fullName: String = "",
        val email: String = "",
        val registrationSuccess: Boolean = false,
        val isLoading: Boolean = false,
        val errorMessage: String? = null
    )
}
