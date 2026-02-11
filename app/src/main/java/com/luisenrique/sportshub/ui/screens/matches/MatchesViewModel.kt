package com.luisenrique.sportshub.ui.screens.matches

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.luisenrique.sportshub.domain.model.Match
import com.luisenrique.sportshub.domain.repository.MatchRepository
import com.luisenrique.sportshub.ui.navigation.Routes
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class MatchesViewModel @Inject constructor(
    repository: MatchRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    val matches: StateFlow<List<Match>> =
        savedStateHandle.getStateFlow<String?>(Routes.MatchesArg, null)
            .flatMapLatest { leagueId ->
                if (leagueId.isNullOrBlank()) {
                    repository.observeMatches()
                } else {
                    repository.observeMatchesByLeague(leagueId)
                }
            }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000),
                initialValue = emptyList()
            )
}
