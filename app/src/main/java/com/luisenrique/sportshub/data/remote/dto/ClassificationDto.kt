package com.luisenrique.sportshub.data.remote.dto

import com.google.gson.annotations.SerializedName

data class ClassificationDto(
    val id: String,
    @SerializedName("team_id") val teamId: String,
    @SerializedName("club_id") val clubId: String,
    @SerializedName("games_played") val gamesPlayed: Int,
    val victories: Int,
    val lost: Int,
    val ties: Int,
    @SerializedName("total_points") val totalPoints: Int
)
