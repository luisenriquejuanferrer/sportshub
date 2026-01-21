package com.luisenrique.sportshub.data.repositoryimpl

import com.luisenrique.sportshub.data.local.dao.UserDao
import com.luisenrique.sportshub.data.local.mapper.toDomain
import com.luisenrique.sportshub.data.local.mapper.toEntity
import com.luisenrique.sportshub.domain.model.User
import com.luisenrique.sportshub.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userDao: UserDao
) : UserRepository {
    override fun observeUsers(): Flow<List<User>> =
        userDao.observeUsers()
            .map { list -> list.map { it.toDomain() }  }

    override suspend fun getUser(id: String): User? =
        userDao.getUser(id)?.toDomain()



}