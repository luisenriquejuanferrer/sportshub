package com.luisenrique.sportshub.data.local.entities

import androidx.room.Embedded
import androidx.room.Relation
import com.luisenrique.sportshub.domain.model.Classification

data class TeamWithPlayers(
    @Embedded val team: TeamEntity,
    @Relation(parentColumn = "id", entityColumn = "teamId")
    val players: List<PlayerEntity>
)

data class LeagueWithTeams(
    @Embedded val league: LeagueEntity,
    @Relation(parentColumn = "id", entityColumn = "leagueId")
    val teams: List<TeamEntity>
)

data class ClubWithTeams(
    @Embedded val club: ClubEntity,
    @Relation(parentColumn = "id", entityColumn = "clubId")
    val teams: List<TeamEntity>
)

data class TeamAndClassification(
    @Embedded val team: TeamEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "teamId"
    )
    val classification: Classification
)

data class ClassificationWithTeamAndClub(
    @Embedded val classification: ClassificationEntity,
    @Relation(
        parentColumn = "team_id",
        entityColumn = "id"
    )
    val team: TeamEntity,
    @Relation(
        parentColumn = "club_id",
        entityColumn = "id"
    )
    val club: ClubEntity
)