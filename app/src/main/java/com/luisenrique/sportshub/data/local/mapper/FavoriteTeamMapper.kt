package com.luisenrique.sportshub.data.local.mapper

import com.luisenrique.sportshub.data.local.entities.FavoriteTeamEntity
import com.luisenrique.sportshub.domain.model.FavoriteTeam

fun FavoriteTeamEntity.toDomain(): FavoriteTeam =
    FavoriteTeam(
        userId = userId,
        teamId = teamId
    )

fun FavoriteTeam.toEntity(): FavoriteTeamEntity =
    FavoriteTeamEntity(
        userId = userId,
        teamId = teamId
    )
