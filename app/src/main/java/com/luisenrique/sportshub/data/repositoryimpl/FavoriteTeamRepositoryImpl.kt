package com.luisenrique.sportshub.data.repository

import com.luisenrique.sportshub.data.local.dao.FavoriteTeamDao
import com.luisenrique.sportshub.data.local.mapper.toDomain
import com.luisenrique.sportshub.data.local.mapper.toEntity
import com.luisenrique.sportshub.domain.model.FavoriteTeam
import com.luisenrique.sportshub.domain.repository.FavoriteTeamRepository
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class FavoriteTeamRepositoryImpl @Inject constructor(
    private val favoriteTeamDao: FavoriteTeamDao
) : FavoriteTeamRepository {
    override fun observeFavoritesByUser(userId: String): Flow<List<FavoriteTeam>> =
        favoriteTeamDao.observeFavoritesByUser(userId).map { list -> list.map { it.toDomain() } }

    override fun isFavorite(userId: String, teamId: String): Flow<Boolean> =
        favoriteTeamDao.isFavorite(userId, teamId)

    override suspend fun insertFavorite(favorite: FavoriteTeam) {
        favoriteTeamDao.insertFavorite(favorite.toEntity())
    }

    override suspend fun deleteFavorite(userId: String, teamId: String) {
        favoriteTeamDao.deleteFavorite(userId, teamId)
    }
}