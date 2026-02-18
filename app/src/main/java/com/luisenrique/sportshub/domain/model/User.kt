package com.luisenrique.sportshub.domain.model

import androidx.annotation.Keep

@Keep
data class User(
    val id: String = "",
    val fullName: String = "",
    val userName: String = "",
    val email: String = "",
    val sex: String = "",
    val memberSince: String = "",
    val verified: Boolean = false
)
