package com.luisenrique.sportshub.ui.screens.matches

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.luisenrique.sportshub.domain.model.Match
import com.luisenrique.sportshub.domain.repository.MatchRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class MatchesViewModel @Inject constructor(
    repository: MatchRepository
) : ViewModel() {
    val matches: StateFlow<List<Match>> =
        repository.observeMatches()
            .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), emptyList())
}