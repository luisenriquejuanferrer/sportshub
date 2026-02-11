package com.luisenrique.sportshub.data.local.mapper

import com.luisenrique.sportshub.data.local.entities.ClubEntity
import com.luisenrique.sportshub.domain.model.Club

fun ClubEntity.toDomain(): Club =
    Club(
        id = id,
        name = name
    )

fun Club.toEntity(): ClubEntity =
    ClubEntity(
        id = id,
        name = name
    )
