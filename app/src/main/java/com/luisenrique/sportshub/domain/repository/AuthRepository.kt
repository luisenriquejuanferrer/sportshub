package com.luisenrique.sportshub.domain.repository

import com.google.firebase.auth.FirebaseUser
import com.luisenrique.sportshub.ui.utils.Resource

interface AuthRepository {
    suspend fun login(email: String, password: String): Resource<FirebaseUser>
}