package com.luisenrique.sportshub.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.luisenrique.sportshub.data.local.entities.ClassificationEntity
import com.luisenrique.sportshub.data.local.entities.ClassificationWithTeamAndClub
import kotlinx.coroutines.flow.Flow

@Dao
interface ClassificationDao {
    @Transaction
    @Query("SELECT * FROM classifications ORDER BY totalPoints DESC")
    fun observeClassifications(): Flow<List<ClassificationWithTeamAndClub>>

    @Transaction
    @Query("SELECT * FROM classifications WHERE id = :id LIMIT 1")
    suspend fun getClassification(id: String): ClassificationWithTeamAndClub?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertAll(items: List<ClassificationEntity>)
}