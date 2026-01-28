package com.luisenrique.sportshub.data.repository

import com.luisenrique.sportshub.data.local.dao.ClubDao
import com.luisenrique.sportshub.data.local.mapper.toDomain
import com.luisenrique.sportshub.domain.model.Club
import com.luisenrique.sportshub.domain.repository.ClubRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ClubRepositoryImpl @Inject constructor(
    private val clubDao: ClubDao
) : ClubRepository {

    override fun observeClubs(): Flow<List<Club>> =
        clubDao.observeClubs().map { list ->
            list.map { it.toDomain() }
        }

    override suspend fun getClub(id: String): Club? =
        clubDao.getClub(id)?.toDomain()
}