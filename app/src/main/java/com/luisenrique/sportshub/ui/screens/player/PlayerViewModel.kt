package com.luisenrique.sportshub.ui.screens.player

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.luisenrique.sportshub.domain.model.Player
import com.luisenrique.sportshub.domain.repository.PlayerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class PlayerViewModel @Inject constructor(
    repository: PlayerRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val playerId: String = checkNotNull(savedStateHandle["playerId"])

    val player: StateFlow<Player?> = repository.observePlayer(playerId)
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = null
        )
}
