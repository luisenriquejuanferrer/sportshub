package com.luisenrique.sportshub.domain.repository

import com.luisenrique.sportshub.domain.model.FavoriteTeam
import kotlinx.coroutines.flow.Flow

interface FavoriteTeamRepository {
    fun observeFavoritesByUser(userId: String): Flow<List<FavoriteTeam>>
    fun isFavorite(userId: String, teamId: String): Flow<Boolean>
    suspend fun insertFavorite(favorite: FavoriteTeam)
    suspend fun deleteFavorite(userId: String, teamId: String)
}