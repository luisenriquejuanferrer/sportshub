package com.luisenrique.sportshub.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "favorites",
    primaryKeys = ["userId", "teamId"]
)
data class FavoriteTeamEntity(
    val userId: String,
    val teamId: String
)
