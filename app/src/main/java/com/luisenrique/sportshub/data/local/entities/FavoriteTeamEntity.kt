package com.luisenrique.sportshub.data.local.entities

import androidx.room.Entity

@Entity(
    tableName = "favorites",
    primaryKeys = ["userId", "teamId"]
)
data class FavoriteTeamEntity(
    val userId: String,
    val teamId: String
)
