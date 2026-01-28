package com.luisenrique.sportshub.domain.repository

import com.luisenrique.sportshub.domain.model.Team
import kotlinx.coroutines.flow.Flow

interface TeamRepository {
    fun observeTeams(): Flow<List<Team>>
    fun observeTeam(id: String): Flow<Team?>
    suspend fun getTeam(id: String): Team?
}