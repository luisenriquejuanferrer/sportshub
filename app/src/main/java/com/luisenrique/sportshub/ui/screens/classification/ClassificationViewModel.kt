package com.luisenrique.sportshub.ui.screens.classification

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.luisenrique.sportshub.domain.model.Classification
import com.luisenrique.sportshub.domain.model.ClassificationApi
import com.luisenrique.sportshub.domain.repository.ClassificationApiRepository
import com.luisenrique.sportshub.domain.repository.ClassificationRepository
import com.luisenrique.sportshub.ui.navigation.Routes
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

sealed class ClassificationUiState {
    object Loading : ClassificationUiState()
    data class FromApi(val items: List<ClassificationApi>) : ClassificationUiState()
    data class FromRoom(val items: List<Classification>) : ClassificationUiState()
}

@HiltViewModel
class ClassificationViewModel @Inject constructor(
    private val roomRepo: ClassificationRepository,
    private val apiRepo: ClassificationApiRepository,
    @ApplicationContext private val context: Context,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private fun isOnline(): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val network = cm.activeNetwork ?: return false
        val caps = cm.getNetworkCapabilities(network) ?: return false
        return caps.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
    }

    val uiState: StateFlow<ClassificationUiState> =
        savedStateHandle.getStateFlow<String?>(Routes.ClasificationArg, null)
            .flatMapLatest { leagueId ->
                if (isOnline()) {
                    apiRepo.observeClassifications().map { list ->
                        val filtered = if (leagueId.isNullOrBlank()) list
                                       else list.filter { it.leagueId == leagueId }
                        ClassificationUiState.FromApi(filtered)
                    }
                } else {
                    val roomFlow = if (leagueId.isNullOrBlank()) {
                        roomRepo.observeClassifications()
                    } else {
                        roomRepo.observeClassificationForLeague(leagueId)
                    }
                    roomFlow.map { ClassificationUiState.FromRoom(it) }
                }
            }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000),
                initialValue = ClassificationUiState.Loading
            )
}
