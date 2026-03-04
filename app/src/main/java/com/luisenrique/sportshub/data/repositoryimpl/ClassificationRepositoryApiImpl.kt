package com.luisenrique.sportshub.data.repositoryimpl

import com.luisenrique.sportshub.data.remote.SportsHubApi
import com.luisenrique.sportshub.domain.model.Classification
import com.luisenrique.sportshub.domain.repository.ClassificationRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import kotlin.collections.emptyList

class ClassificationRepositoryApiImpl @Inject constructor(
    private val api: SportsHubApi
) : ClassificationRepository {
    override fun observeClassifications(): Flow<List<Classification>> = flow {
        emit(emptyList())
    }

    override fun observeClassificationForLeague(leagueId: String): Flow<List<Classification>> =
        flow {
            val dtos = api.getClassifications(leagueId = leagueId)
            emit(emptyList())
        }

    override suspend fun getClassification(id: String): Classification? = null

    override fun observeClassificationForTeam(teamId: String): Flow<Classification?> = flow {
        emit(null)
    }
}