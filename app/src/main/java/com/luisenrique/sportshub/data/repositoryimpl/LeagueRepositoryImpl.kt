package com.luisenrique.sportshub.data.repository

import com.luisenrique.sportshub.data.local.dao.LeagueDao
import com.luisenrique.sportshub.data.local.mapper.toDomain
import com.luisenrique.sportshub.domain.model.League
import com.luisenrique.sportshub.domain.repository.LeagueRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class LeagueRepositoryImpl @Inject constructor(
    private val leagueDao: LeagueDao
) : LeagueRepository {
    override fun observeLeagues(): Flow<List<League>> =
        leagueDao.observeLeagues().map { list -> list.map { it.toDomain() } }

    override suspend fun getLeague(id: String): League? =
        leagueDao.getLeague(id)?.toDomain()
}