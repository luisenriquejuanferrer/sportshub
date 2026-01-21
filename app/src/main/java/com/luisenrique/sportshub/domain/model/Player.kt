package com.luisenrique.sportshub.domain.model

data class Player(
    val id: String,
    val teamId: String,
    val name: String,
    val position: String,
    val number: Int?,
    val nationality: String?,
    val foot: String?,
    val height: Int?,
    val weight: Int?,
    val goals: Int?,
    val assists: Int?,
    val games: Int?
)
    