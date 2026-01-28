package com.luisenrique.sportshub.data.local.mapper

import com.luisenrique.sportshub.data.local.entities.PlayerEntity
import com.luisenrique.sportshub.data.local.entities.UserEntity
import com.luisenrique.sportshub.domain.model.Player
import kotlin.String

fun PlayerEntity.toDomain(): Player =
    Player(
        id = id,
        teamId = teamId,
        name = name,
        position = position,
        number = number,
        nationality = nationality,
        foot = foot,
        height = height,
        weight = weight,
        goals = goals,
        assists = assists,
        games = games,
        age = age
    )

fun Player.toEntity(): PlayerEntity =
    PlayerEntity(
        id = id,
        teamId = teamId,
        name = name,
        position = position,
        number = number,
        nationality = nationality,
        foot = foot,
        height = height,
        weight = weight,
        goals = goals,
        assists = assists,
        games = games,
        age = age
    )

