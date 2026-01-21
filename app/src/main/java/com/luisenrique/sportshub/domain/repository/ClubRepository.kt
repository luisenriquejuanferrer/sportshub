package com.luisenrique.sportshub.domain.repository

import com.luisenrique.sportshub.domain.model.Club
import kotlinx.coroutines.flow.Flow

interface ClubRepository {
    fun observeClubs(): Flow<List<Club>>
    suspend fun getClub(id: String): Club?
}

