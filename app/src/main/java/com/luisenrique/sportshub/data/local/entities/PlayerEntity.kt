package com.luisenrique.sportshub.data.local.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "player",
    indices = [Index(value = ["teamId"])], // Added index on teamId
    foreignKeys = [
        ForeignKey(
            entity = TeamEntity::class,
            parentColumns = ["id"],
            childColumns = ["teamId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class PlayerEntity(
    @PrimaryKey val id: String,
    val teamId: String,
    val name: String,
    val position: String,
    val number: Int?,
    val nationality: String?,
    val foot: String?,
    val age: Int?,
    val height: Int?,
    val weight: Int?,
    val goals: Int?,
    val assists: Int?,
    val games: Int?
)
