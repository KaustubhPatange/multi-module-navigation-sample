package com.kpstv.home.fragments

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.kpstv.core.di.viewmodel.AssistedSavedStateViewModelFactory
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class HomeStartViewModel @AssistedInject constructor(
  @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {

  val state: Flow<HomeStartState> = flow {
    emit(HomeStartState.Loading)
    delay(1000)
    emit(HomeStartState.Completed)
  }

  @AssistedFactory
  interface Factory : AssistedSavedStateViewModelFactory<HomeStartViewModel>
}

sealed class HomeStartState(val text: String, val enabled: Boolean) {
  object Loading : HomeStartState("Loading in 1s...", false)
  object Completed : HomeStartState("Completed", true)
}