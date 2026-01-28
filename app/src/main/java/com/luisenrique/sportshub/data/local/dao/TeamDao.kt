package com.luisenrique.sportshub.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.luisenrique.sportshub.data.local.entities.TeamEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TeamDao {
    @Query("SELECT * FROM team ORDER BY id DESC")
    fun observeTeams(): Flow<List<TeamEntity>>

    @Query("SELECT * FROM team WHERE id = :id LIMIT 1")
    fun observeTeam(id: String): Flow<TeamEntity?>

    @Query("SELECT * FROM team WHERE id = :id LIMIT 1")
    suspend fun getTeam(id: String): TeamEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertAll(items: List<TeamEntity>)
}
