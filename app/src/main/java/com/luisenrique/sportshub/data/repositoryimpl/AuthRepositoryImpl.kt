package com.luisenrique.sportshub.data.repositoryimpl

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.luisenrique.sportshub.domain.repository.AuthRepository
import com.luisenrique.sportshub.ui.utils.Resource
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val firebaseAuth: FirebaseAuth
) : AuthRepository {
    override suspend fun login(email: String, password: String): Resource<FirebaseUser> {
        return try {
            val result = firebaseAuth.signInWithEmailAndPassword(email, password).await()
            result.user?.let {
                Resource.Success(it)
            } ?: Resource.Error(Exception("Error desconocido"))
        } catch (e: Exception) {
            Resource.Error(e)
        }
    }
}
