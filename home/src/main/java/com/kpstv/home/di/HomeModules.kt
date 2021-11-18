package com.kpstv.home.di

import androidx.fragment.app.FragmentFactory
import com.kpstv.core.di.DaggerFragmentFactory
import com.kpstv.home.HomeInternalButtonClickedImpl
import com.kpstv.home.HomeDependency
import com.kpstv.home_internal.HomeInternalButtonClicked
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.migration.DisableInstallInCheck

@Module
@DisableInstallInCheck
abstract class HomeModule {
  @Binds
  abstract fun homeButtonClicked(homeButtonClicked: HomeInternalButtonClickedImpl): HomeInternalButtonClicked

  @Binds
  @HomeScope
  abstract fun fragmentFactory(daggerFragmentFactory: DaggerFragmentFactory): FragmentFactory
}

@Module
@DisableInstallInCheck
class HomeDependencyModule {
  @Provides
  fun homeDependency(): HomeDependency = HomeDependency()
}