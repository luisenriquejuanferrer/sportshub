package com.luisenrique.sportshub.data.local.mapper

import com.luisenrique.sportshub.data.local.entities.LeagueEntity
import com.luisenrique.sportshub.domain.model.League

fun LeagueEntity.toDomain(): League =
    League(
        id = id,
        name = name,
        country = country,
        season = season,
        logoUrl = logoUrl,
    )

fun League.toEntity(): LeagueEntity =
    LeagueEntity(
        id = id,
        name = name,
        country = country,
        season = season,
        logoUrl = logoUrl
    )
