package com.luisenrique.sportshub.ui.screens.leagues

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.luisenrique.sportshub.domain.repository.LeagueRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class LeaguesViewModel @Inject constructor(
    private val leagueRepository: LeagueRepository,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    val leagues = leagueRepository.observeLeagues()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = emptyList()
        )

    val league = leagueRepository.observeLeague(savedStateHandle.get<String>("leagueId") ?: "")
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = null
        )
}