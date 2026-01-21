package com.luisenrique.sportshub.data.repositoryimpl

import com.luisenrique.sportshub.data.local.dao.TeamDao
import com.luisenrique.sportshub.data.local.mapper.toDomain
import com.luisenrique.sportshub.domain.model.Team
import com.luisenrique.sportshub.domain.repository.TeamRepository
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class TeamRepositoryImpl @Inject constructor(
    private val teamDao: TeamDao
) : TeamRepository {

    override fun observeTeams() = teamDao.observeTeams()
        .map { list -> list.map { it.toDomain() } }

    override suspend fun getTeam(id: String) : Team? =
        teamDao.getTeam(id)?.toDomain()

}

