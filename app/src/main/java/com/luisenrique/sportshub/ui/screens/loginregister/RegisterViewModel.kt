package com.luisenrique.sportshub.ui.screens.loginregister

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.luisenrique.sportshub.domain.model.User
import com.luisenrique.sportshub.domain.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.util.UUID
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
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

    fun onRegisterClick() {
        viewModelScope.launch {
            val state = uiState.value
            if (state.userName.isNotBlank() && state.fullName.isNotBlank() && state.email.isNotBlank()) {
                val user = User(
                    id = UUID.randomUUID().toString(),
                    fullName = state.fullName,
                    userName = state.userName,
                    email = state.email,
                    memberSince = LocalDate.now().toString(),
                    verified = false
                )
                userRepository.registerUser(user)
                _uiState.update { it.copy(registrationSuccess = true) }
            }
        }
    }
}

data class RegisterUiState(
    val userName: String = "",
    val fullName: String = "",
    val email: String = "",
    val registrationSuccess: Boolean = false
)
