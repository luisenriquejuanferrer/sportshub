package com.luisenrique.sportshub.domain.repository

import com.luisenrique.sportshub.domain.model.League
import kotlinx.coroutines.flow.Flow

interface LeagueRepository {
    fun observeLeagues(): Flow<List<League>>
    fun observeLeague(id: String): Flow<League?>
    suspend fun getLeague(id: String): League?
}
