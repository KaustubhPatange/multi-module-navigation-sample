package com.kpstv.home.di

import com.kpstv.home.navigation.home_internal.HomeInternalButtonClickedImpl
import com.kpstv.home.HomeDependency
import com.kpstv.home_internal.HomeInternalButtonClicked
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@Module
@InstallIn(FragmentComponent::class)
class HomeDependencyModule {
  @Provides
  fun homeDependency(): HomeDependency = HomeDependency()
}

@Module
@InstallIn(FragmentComponent::class)
abstract class HomeModule {

  @Binds
  abstract fun provideHomeInternalButtonClick(homeButtonClicked: HomeInternalButtonClickedImpl) : HomeInternalButtonClicked
}
