package com.kpstv.navigator_multimodule_test.di

import android.app.Application
import com.kpstv.navigator_multimodule_test.App
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [])
interface AppComponent {

  fun activityComponent() : ActivityComponent.Factory

  @Component.Factory
  interface Factory {
    fun create(@BindsInstance application: Application) : AppComponent
  }

  fun inject(app: App)
}


interface AppComponentProvider {
  val appComponent: AppComponent
}