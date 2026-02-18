package com.luisenrique.sportshub.ui.screens.user

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.luisenrique.sportshub.domain.model.User
import com.luisenrique.sportshub.domain.repository.UserRepository
import com.luisenrique.sportshub.ui.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

// Estado para manejar la UI de forma clara
sealed class UserState {
    object Loading : UserState()
    data class Success(val user: User) : UserState()
    data class Error(val message: String) : UserState()
}

@HiltViewModel
class UserViewModel @Inject constructor(
    private val userRepository: UserRepository,
    private val firebaseAuth: FirebaseAuth // Inyectamos FirebaseAuth para saber quién es el usuario actual
) : ViewModel() {

    private val _userState = MutableStateFlow<UserState>(UserState.Loading)
    val userState: StateFlow<UserState> = _userState

    init {
        // En cuanto el ViewModel se crea, intentamos cargar el usuario.
        fetchCurrentUser()
    }

    private fun fetchCurrentUser() {
        viewModelScope.launch {
            _userState.value = UserState.Loading

            // 1. Obtenemos el UID del usuario logueado
            val userId = firebaseAuth.currentUser?.uid

            if (userId != null) {
                // 2. Usamos el repositorio para buscar el usuario en Firestore
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
