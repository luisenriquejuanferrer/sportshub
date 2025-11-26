package com.ieschabas.navigationcompose.navigation
import kotlinx.serialization.Serializable

@Serializable
data class UserProfile(
    val id: String,
    val name: String,
    val age: Int
)