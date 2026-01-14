package com.luisenrique.sportshub.ui.screens.classification

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.luisenrique.sportshub.domain.repository.ClassificationRepository
import com.luisenrique.sportshub.domain.model.Classification
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class ClassificationViewModel @Inject constructor(
    repository: ClassificationRepository
) : ViewModel() {
    val classifications: StateFlow<List<Classification>> =
        repository.observeClassifications()
            .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), emptyList())
}