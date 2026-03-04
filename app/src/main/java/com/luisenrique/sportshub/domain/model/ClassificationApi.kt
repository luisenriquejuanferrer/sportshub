package com.luisenrique.sportshub.domain.model

data class ClassificationApi(
    val id: String,
    val leagueId: String,
    val teamId: String,
    val clubId: String,
    val gamesPlayed: Int,
    val victories: Int,
    val lost: Int,
    val ties: Int,
    val totalPoints: Int
)
