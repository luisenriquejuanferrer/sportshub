package com.luisenrique.sportshub.data.repositoryimpl

import com.luisenrique.sportshub.data.local.dao.MatchDao
import com.luisenrique.sportshub.data.local.mapper.toDomain
import com.luisenrique.sportshub.domain.model.Match
import com.luisenrique.sportshub.domain.repository.MatchRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class MatchRepositoryImpl @Inject constructor(
    private val matchDao: MatchDao
) : MatchRepository { // Added the interface implementation

    override fun observeMatches(): Flow<List<Match>> =
        matchDao.observeMatches()
            .map { list -> list.map { it.toDomain() } }

    override suspend fun getMatch(id: String): Match? =
        matchDao.getMatch(id)?.toDomain()

    override fun observeMatchesByLeague(leagueId: String): Flow<List<Match>> =
        matchDao.observeMatchesByLeague(leagueId)
            .map { list -> list.map { it.toDomain() } }
}
