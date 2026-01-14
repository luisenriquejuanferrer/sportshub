package com.luisenrique.sportshub.data.local.mapper

import com.luisenrique.sportshub.data.local.entities.ClassificationEntity
import com.luisenrique.sportshub.domain.model.Classification

fun ClassificationEntity.toDomain(): Classification =
    Classification(
        id = id,
        teamId = teamId,
        clubId = clubId,
        gamesPlayed = gamesPlayed,
        victories = victories,
        lost = lost,
        ties = ties,
        totalPoints = totalPoints
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