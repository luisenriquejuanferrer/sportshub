package com.luisenrique.sportshub.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.luisenrique.sportshub.data.local.entities.MatchEntity
import com.luisenrique.sportshub.data.local.entities.MatchWithTeams
import kotlinx.coroutines.flow.Flow

@Dao
interface MatchDao {
    @Transaction
    @Query("SELECT * FROM matches")
    fun observeMatches(): Flow<List<MatchWithTeams>>

    @Transaction
    @Query("SELECT * FROM matches WHERE leagueId = :leagueId")
    fun observeMatchesByLeague(leagueId: String): Flow<List<MatchWithTeams>>

    @Transaction
    @Query("SELECT * FROM matches WHERE id = :id LIMIT 1")
    suspend fun getMatch(id: String): MatchWithTeams?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertAll(matches: List<MatchEntity>)
}