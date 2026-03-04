package com.luisenrique.sportshub.data.repositoryimpl

import com.luisenrique.sportshub.data.remote.SportsHubApi
import com.luisenrique.sportshub.domain.model.ClassificationApi
import com.luisenrique.sportshub.domain.repository.ClassificationApiRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ClassificationRepositoryApiImpl @Inject constructor(
    private val api: SportsHubApi
) : ClassificationApiRepository {
    override fun observeClassifications(): Flow<List<ClassificationApi>> = flow {
        try {
            emit(api.getClassifications().map { dto ->
                ClassificationApi(
                    id = dto.id,
                    leagueId = dto.leagueId,
                    teamId = dto.teamId,
                    clubId = dto.clubId,
                    gamesPlayed = dto.gamesPlayed,
                    victories = dto.victories,
                    lost = dto.lost,
                    ties = dto.ties,
                    totalPoints = dto.totalPoints
                )
            })
        } catch (e: Exception) {
            emit(emptyList())
        }
    }
}
