package com.luisenrique.sportshub.domain.repository

import com.luisenrique.sportshub.domain.model.Classification
import kotlinx.coroutines.flow.Flow

interface ClassificationRepository {
    fun observeClassifications(): Flow<List<Classification>>
    fun observeClassificationForLeague(leagueId: String): Flow<List<Classification>>
    suspend fun getClassification(id: String): Classification?
}
