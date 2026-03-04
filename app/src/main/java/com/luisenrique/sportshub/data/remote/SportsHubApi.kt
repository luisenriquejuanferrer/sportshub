package com.luisenrique.sportshub.data.remote

import com.luisenrique.sportshub.data.remote.dto.ClassificationDto
import retrofit2.http.GET
import retrofit2.http.Query

interface SportsHubApi {
    @GET("classifications")
    suspend fun getClassifications(
        @Query("leagueId") leagueId: String? = null
    ): List<ClassificationDto>
}