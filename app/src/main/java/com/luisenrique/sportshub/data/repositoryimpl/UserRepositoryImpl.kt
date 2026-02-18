package com.luisenrique.sportshub.data.repositoryimpl

import com.google.firebase.firestore.FirebaseFirestore
import com.luisenrique.sportshub.domain.model.User
import com.luisenrique.sportshub.domain.repository.UserRepository
import com.luisenrique.sportshub.ui.utils.Resource
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val firestore: FirebaseFirestore
) : UserRepository {
    override suspend fun getUser(userId: String): Resource<User> {
        return try {
            val document = firestore.collection("users").document(userId).get().await()
            val user = document.toObject(User::class.java)
            user?.let {
                Resource.Success(it)
            } ?: Resource.Error(Exception("Usuario no encontrado."))
        } catch (e: Exception) {
            Resource.Error(e)
        }
    }
}
