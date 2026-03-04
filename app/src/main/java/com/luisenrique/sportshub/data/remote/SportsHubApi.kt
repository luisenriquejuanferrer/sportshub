package com.luisenrique.sportshub.data.remote

import com.luisenrique.sportshub.data.remote.dto.ClassificationDto
import retrofit2.http.GET

interface SportsHubApi {
    @GET("classifications")
    suspend fun getClassifications(): List<ClassificationDto>
}