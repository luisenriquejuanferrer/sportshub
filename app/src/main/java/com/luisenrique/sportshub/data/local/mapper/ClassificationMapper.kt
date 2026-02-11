package com.luisenrique.sportshub.data.local.mapper

import com.luisenrique.sportshub.data.local.entities.ClassificationEntity
import com.luisenrique.sportshub.data.local.entities.ClassificationWithTeamAndClub
import com.luisenrique.sportshub.domain.model.Classification

fun ClassificationWithTeamAndClub.toDomain(): Classification =
    Classification(
        id = classification.id,
        teamId = classification.teamId,
        clubId = classification.clubId,
        gamesPlayed = classification.gamesPlayed,
        victories = classification.victories,
        lost = classification.lost,
        ties = classification.ties,
        totalPoints = classification.totalPoints,
        team = team.toDomain(),
        club = club.toDomain()
    )

fun Classification.toEntity(): ClassificationEntity =
    ClassificationEntity(
        id = id,
        teamId = teamId,
        clubId = clubId,
        gamesPlayed = gamesPlayed,
        victories = victories,
        lost = lost,
        ties = ties,
        totalPoints = totalPoints
    )
