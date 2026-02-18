package com.luisenrique.sportshub.ui.screens.user

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.luisenrique.sportshub.domain.model.User
import com.luisenrique.sportshub.domain.repository.AuthRepository
import com.luisenrique.sportshub.domain.repository.UserRepository
import com.luisenrique.sportshub.ui.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed class UserState {
    object Loading : UserState()
    data class Success(val user: User) : UserState()
    data class Error(val message: String) : UserState()
}

@HiltViewModel
class UserViewModel @Inject constructor(
    private val userRepository: UserRepository,
    private val authRepository: AuthRepository,
    private val firebaseAuth: FirebaseAuth
) : ViewModel() {

    private val _userState = MutableStateFlow<UserState>(UserState.Loading)
    val userState: StateFlow<UserState> = _userState

    private val _logoutCompleted = MutableStateFlow(false)
    val logoutCompleted: StateFlow<Boolean> = _logoutCompleted

    init {
        fetchCurrentUser()
    }

    fun logout() {
        authRepository.logout()
        _logoutCompleted.value = true
    }

    fun onLogoutHandled() {
        _logoutCompleted.value = false
    }

    private fun fetchCurrentUser() {
        viewModelScope.launch {
            _userState.value = UserState.Loading

            val userId = firebaseAuth.currentUser?.uid

            if (userId != null) {
                when (val result = userRepository.getUser(userId)) {
                    is Resource.Success -> {
                        _userState.value = UserState.Success(result.data)
                    }
                    is Resource.Error -> {
                        _userState.value = UserState.Error(result.exception.message ?: "Error al cargar el usuario.")
                    }
                    else -> { }
                }
            } else {
                _userState.value = UserState.Error("No se ha podido encontrar la sesión del usuario.")
            }
        }
    }
}
