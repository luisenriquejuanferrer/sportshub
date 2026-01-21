package com.luisenrique.sportshub.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("user")
data class UserEntity(
    @PrimaryKey val id: String,
    val fullName: String,
    val username: String,
    val email: String,
    val memberSince: String,
    val verified: Boolean
)
