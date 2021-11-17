package com.kpstv.core.di.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

interface AssistedSavedStateViewModelFactory<T : ViewModel> {
  fun create(savedStateHandle: SavedStateHandle): T
}

