package com.kpstv.home.di

import com.kpstv.home.HomeFragment
import dagger.BindsInstance
import dagger.Module
import dagger.Subcomponent
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@InstallIn(FragmentComponent::class)
@Module(includes = [HomeFragmentModule::class, HomeDependencyModule::class, HomeModule::class])
interface HomeAggregatorModule

@EntryPoint
@InstallIn(FragmentComponent::class)
interface HomeComponent {

 /* @Subcomponent.Factory
  interface Factory {
    fun create(@BindsInstance fragment: HomeFragment) : HomeComponent
  }*/

  fun inject(home: HomeFragment)
}

interface HomeComponentProvider {
  val homeComponent: HomeComponent
}