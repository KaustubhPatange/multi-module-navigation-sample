package com.kpstv.navigator_multimodule_test.di

import androidx.fragment.app.FragmentFactory
import com.kpstv.core.di.DaggerFragmentFactory
import com.kpstv.navigator_multimodule_test.navigation.welcome.WelcomeButtonClickImpl
import com.kpstv.welcome.WelcomeButtonClick
import dagger.Binds
import dagger.Module

@Module
abstract class ActivityModule {
  @Binds
  abstract fun provideWelcomeButtonClick(welcomeButtonClick: WelcomeButtonClickImpl) : WelcomeButtonClick

  @Binds
  abstract fun fragmentFactory(daggerFragmentFactory: DaggerFragmentFactory): FragmentFactory
}