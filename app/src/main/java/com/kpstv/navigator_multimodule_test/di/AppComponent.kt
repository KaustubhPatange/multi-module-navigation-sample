package com.kpstv.navigator_multimodule_test.di

import android.app.Application
import com.kpstv.home_internal.di.HomeInternalWorkerModule
import com.kpstv.navigator_multimodule_test.App
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [HomeInternalWorkerModule::class])
interface AppComponent {

  fun activityComponent() : ActivityComponent.Factory

  fun inject(app: App)

  @Component.Factory
  interface Factory {
    fun create(@BindsInstance application: Application) : AppComponent
  }
}

interface AppComponentProvider {
  val appComponent: AppComponent
}