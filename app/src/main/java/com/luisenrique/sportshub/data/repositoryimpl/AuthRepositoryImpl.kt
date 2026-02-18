package com.luisenrique.sportshub.data.repositoryimpl

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.FirebaseFirestore
import com.luisenrique.sportshub.domain.model.User
import com.luisenrique.sportshub.domain.repository.AuthRepository
import com.luisenrique.sportshub.ui.utils.Resource
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val firebaseAuth: FirebaseAuth,
    private val firestore: FirebaseFirestore
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

    override suspend fun register(email: String, password: String, user: User): Resource<Boolean> {
        return try {
            val authResult = firebaseAuth.createUserWithEmailAndPassword(email, password).await()
            val userId = authResult.user?.uid ?: throw Exception("El ID de usuario es nulo")

            val newUser = user.copy(id = userId)

            firestore.collection("users")
                .document(userId)
                .set(newUser)
                .await()

            Resource.Success(true)
        } catch (e: Exception) {
            Resource.Error(e)
        }
    }
}
