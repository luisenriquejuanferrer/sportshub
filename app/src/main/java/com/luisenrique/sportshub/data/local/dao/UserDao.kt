package com.luisenrique.sportshub.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.luisenrique.sportshub.data.local.entities.UserEntity
import kotlinx.coroutines.flow.Flow
@Dao
interface UserDao {
    @Query("SELECT * FROM user ORDER BY id DESC")
    fun observeUsers(): Flow<List<UserEntity>>

    @Query("SELECT * FROM user WHERE id = :id LIMIT 1")
    suspend fun getUser(id: String): UserEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(user: UserEntity)
}
