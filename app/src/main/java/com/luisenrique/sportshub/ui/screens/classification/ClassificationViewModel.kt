package com.luisenrique.sportshub.ui.screens.classification

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.luisenrique.sportshub.domain.model.Classification
import com.luisenrique.sportshub.domain.repository.ClassificationRepository
import com.luisenrique.sportshub.ui.navigation.Routes
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class ClassificationViewModel @Inject constructor(
    repository: ClassificationRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    val classifications: StateFlow<List<Classification>> =
        savedStateHandle.getStateFlow<String?>(Routes.ClasificationArg, null)
            .flatMapLatest { leagueId ->
                if (leagueId.isNullOrBlank()) {
                    repository.observeClassifications()
                } else {
                    repository.observeClassificationForLeague(leagueId)
                }
            }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000),
                initialValue = emptyList()
            )
}
