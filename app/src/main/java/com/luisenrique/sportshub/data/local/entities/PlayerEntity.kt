package com.luisenrique.sportshub.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "player")
data class PlayerEntity(
    @PrimaryKey val id: String,
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
