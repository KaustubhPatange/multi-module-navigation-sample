package com.kpstv.home.di

import androidx.fragment.app.FragmentFactory
import androidx.lifecycle.ViewModel
import androidx.savedstate.SavedStateRegistryOwner
import com.kpstv.core.di.DaggerFragmentFactory
import com.kpstv.core.di.ViewModelKey
import com.kpstv.core.di.viewmodel.AssistedSavedStateViewModelFactory
import com.kpstv.home.HomeInternalButtonClickedImpl
import com.kpstv.home.HomeDependency
import com.kpstv.home.HomeFragment
import com.kpstv.home.fragments.HomeStartViewModel
import com.kpstv.home_internal.HomeInternalButtonClicked
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
abstract class HomeModule {
  @Binds
  abstract fun homeButtonClicked(homeButtonClicked: HomeInternalButtonClickedImpl): HomeInternalButtonClicked

  @Binds
  @HomeScope
  abstract fun fragmentFactory(daggerFragmentFactory: DaggerFragmentFactory): FragmentFactory
}

@Module
abstract class HomeViewModule {
  @Binds
  @IntoMap
  @ViewModelKey(HomeStartViewModel::class)
  abstract fun homeStartViewModel(factory: HomeStartViewModel.Factory) : AssistedSavedStateViewModelFactory<out ViewModel>
}

@Module
class HomeDependencyModule {
  @Provides
  fun homeDependency(): HomeDependency = HomeDependency()

  @Provides
  fun saveStateRegistryOwner(fragment: HomeFragment) : SavedStateRegistryOwner = fragment
}