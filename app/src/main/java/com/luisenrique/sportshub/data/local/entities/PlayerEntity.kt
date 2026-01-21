package com.luisenrique.sportshub.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("players")
data class PlayerEntity(
    @PrimaryKey val id: String,
    val teamId: String,
    val name: String,
    val position: String,
    val number: Int,
    val nationality: String
)
