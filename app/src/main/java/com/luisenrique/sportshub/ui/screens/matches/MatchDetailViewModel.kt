package com.luisenrique.sportshub.ui.screens.matches

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.luisenrique.sportshub.domain.model.Match
import com.luisenrique.sportshub.domain.repository.MatchRepository
import com.luisenrique.sportshub.ui.navigation.Routes
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MatchDetailViewModel @Inject constructor(
    private val repository: MatchRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val matchId: String = checkNotNull(savedStateHandle[Routes.MatchDetailArg])

    private val _state = MutableStateFlow<Match?>(null)
    val state: StateFlow<Match?> = _state.asStateFlow()

    init {
        getMatchDetails()
    }

    private fun getMatchDetails() {
        viewModelScope.launch {
            // Asumiendo que tu repositorio tiene una función getMatch(id)
            val match = repository.getMatch(matchId)
            _state.value = match
        }
    }
}