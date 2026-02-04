package com.luisenrique.sportshub.domain.repository

import com.luisenrique.sportshub.domain.model.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    fun observeUsers(): Flow<List<User>>
    suspend fun getUser(id: String): User?
    suspend fun registerUser(user: User)
}