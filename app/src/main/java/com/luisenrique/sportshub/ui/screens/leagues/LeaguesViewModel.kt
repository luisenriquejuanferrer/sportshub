package com.luisenrique.sportshub.ui.screens.leagues

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.luisenrique.sportshub.domain.model.League
import com.luisenrique.sportshub.domain.repository.LeagueRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class LeaguesViewModel @Inject constructor(
    repository: LeagueRepository
) : ViewModel() {
    val leagues: StateFlow<List<League>> =
        repository.observeLeagues()
            .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), emptyList())
}