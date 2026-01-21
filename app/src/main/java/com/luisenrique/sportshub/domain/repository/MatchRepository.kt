package com.luisenrique.sportshub.domain.repository

import com.luisenrique.sportshub.domain.model.Match
import kotlinx.coroutines.flow.Flow

interface MatchRepository {
    fun observeMatches(): Flow<List<Match>>
    fun observeMatchesByLeague(leagueId: String): Flow<List<Match>>
    suspend fun getMatch(id: String): Match?
}