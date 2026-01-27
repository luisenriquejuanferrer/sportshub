package com.luisenrique.sportshub.data.local.mapper

import com.luisenrique.sportshub.data.local.entities.TeamEntity
import com.luisenrique.sportshub.domain.model.Team

fun TeamEntity.toDomain(): Team =
    Team(
        id = id,
        leagueId = leagueId,
        clubId = clubId,
        name = name,
        city = city,
        founded = founded,
        crestUrl = crestUrl
    )

fun Team.toEntity(): TeamEntity =
    TeamEntity(
        id = id,
        leagueId = leagueId,
        clubId = clubId,
        name = name,
        city = city,
        founded = founded,
        crestUrl = crestUrl
    )