package com.luisenrique.sportshub.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.luisenrique.sportshub.data.local.entities.LeagueEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface LeagueDao {
    @Query("SELECT * FROM leagues ORDER BY name ASC")
    fun observeLeagues(): Flow<List<LeagueEntity>>

    @Query("SELECT * FROM leagues WHERE id = :id LIMIT 1")
    fun observeLeague(id: String): Flow<LeagueEntity?>

    @Query("SELECT * FROM leagues WHERE id = :id LIMIT 1")
    suspend fun getLeague(id: String): LeagueEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertAll(leagues: List<LeagueEntity>)
}
