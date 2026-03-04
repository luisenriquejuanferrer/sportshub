package com.luisenrique.sportshub.domain.repository

import com.luisenrique.sportshub.domain.model.ClassificationApi
import kotlinx.coroutines.flow.Flow

interface ClassificationApiRepository {
    fun observeClassifications(): Flow<List<ClassificationApi>>
}
