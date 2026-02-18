package com.luisenrique.sportshub.domain.repository

import com.luisenrique.sportshub.domain.model.User
import com.luisenrique.sportshub.ui.utils.Resource

interface UserRepository {
    suspend fun getUser(userId: String): Resource<User>
}
