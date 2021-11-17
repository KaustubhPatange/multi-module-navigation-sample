package com.kpstv.navigator_multimodule_test

import android.app.Application
import androidx.work.Configuration
import com.kpstv.core.di.workmanager.InjectDaggerWorkerFactory
import com.kpstv.navigator_multimodule_test.di.AppComponentProvider
import com.kpstv.navigator_multimodule_test.di.DaggerAppComponent
import javax.inject.Inject

class App : Application(), AppComponentProvider, Configuration.Provider {
  override val appComponent by lazy { DaggerAppComponent.factory().create(this) }

  @Inject lateinit var workerFactory: dagger.Lazy<InjectDaggerWorkerFactory>

  override fun getWorkManagerConfiguration(): Configuration {
    return Configuration.Builder().setWorkerFactory(workerFactory.get()).build()
  }

  override fun onCreate() {
    appComponent.inject(this)
    super.onCreate()
  }
}