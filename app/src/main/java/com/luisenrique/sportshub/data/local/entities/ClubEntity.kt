package com.luisenrique.sportshub.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("clubs")
class ClubEntity(
    @PrimaryKey val id: String,
    val name: String
)