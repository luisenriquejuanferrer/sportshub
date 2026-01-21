package com.luisenrique.sportshub.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("leagues")
data class LeagueEntity(
    @PrimaryKey val id: String,
    val name: String,
    val country: String,
    val season: String,
    val logoUrl: String?
)
