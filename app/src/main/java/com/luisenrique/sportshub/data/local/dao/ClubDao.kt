package com.luisenrique.sportshub.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.luisenrique.sportshub.data.local.entities.ClubEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ClubDao {
    @Query("SELECT * FROM clubs")
    fun observeClubs(): Flow<List<ClubEntity>>

    @Query("SELECT * FROM clubs WHERE id = :id LIMIT 1")
    suspend fun getClub(id: String): ClubEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertAll(clubs: List<ClubEntity>)
}