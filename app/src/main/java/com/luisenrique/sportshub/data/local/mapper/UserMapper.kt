package com.luisenrique.sportshub.data.local.mapper

import com.luisenrique.sportshub.data.local.entities.UserEntity
import com.luisenrique.sportshub.domain.model.User

fun UserEntity.toDomain(): User =
    User(
        id = id,
        fullName = fullName,
        userName = userName,
        email = email,
        memberSince = memberSince,
        verified = verified
    )

fun User.toEntity(): UserEntity =
    UserEntity(
        id = id,
        fullName = fullName,
        userName = userName,
        email = email,
        memberSince = memberSince,
        verified = verified
    )
