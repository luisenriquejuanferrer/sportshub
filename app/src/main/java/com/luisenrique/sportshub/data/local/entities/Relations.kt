package com.luisenrique.sportshub.data.local.entities

import androidx.room.Embedded
import androidx.room.Relation

data class TeamWithPlayers(
    @Embedded val team: TeamEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "teamId")
    val players: List<PlayerEntity>
)

