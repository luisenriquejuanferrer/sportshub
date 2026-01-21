package com.luisenrique.sportshub.domain.model

data class User(
    val id: String,
    val fullName: String,
    val userName: String,
    val email: String,
    val memberSince: String,
    val verified: Boolean
)
