package com.luisenrique.sportshub.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.luisenrique.sportshub.data.local.entities.MatchEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MatchDao {
    @Query("SELECT * FROM matches ORDER BY dateUtc DESC")
    fun observeMatches(): Flow<List<MatchEntity>>

    // Muy útil para mostrar partidos de una liga concreta
    @Query("SELECT * FROM matches WHERE leagueId = :leagueId ORDER BY dateUtc DESC")
    fun observeMatchesByLeague(leagueId: String): Flow<List<MatchEntity>>

    @Query("SELECT * FROM matches WHERE id = :id LIMIT 1")
    suspend fun getMatch(id: String): MatchEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertAll(matches: List<MatchEntity>)
}