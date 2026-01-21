package com.luisenrique.sportshub.domain.repository

import com.luisenrique.sportshub.domain.model.Player
import kotlinx.coroutines.flow.Flow

interface PlayerRepository {
    fun observePlayers(): Flow<List<Player>>
    suspend fun getPlayer(id: String): Player?

}