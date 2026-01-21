package com.luisenrique.sportshub.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.luisenrique.sportshub.data.local.entities.FavoriteTeamEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteTeamDao {
    @Query("SELECT * FROM favorites WHERE userId = :userId")
    fun observeFavoritesByUser(userId: String): Flow<List<FavoriteTeamEntity>>

    // Útil para saber si un equipo concreto es favorito y pintar el "corazón" relleno
    @Query("SELECT EXISTS(SELECT 1 FROM favorites WHERE userId = :userId AND teamId = :teamId)")
    fun isFavorite(userId: String, teamId: String): Flow<Boolean>

    @Query("DELETE FROM favorites WHERE userId = :userId AND teamId = :teamId")
    suspend fun deleteFavorite(userId: String, teamId: String)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavorite(favorite: FavoriteTeamEntity)
}