package com.kpstv.navigator_multimodule_test

import android.app.Application
import androidx.hilt.work.HiltWorkerFactory
import androidx.work.Configuration
import androidx.work.WorkerFactory
import com.kpstv.navigator_multimodule_test.di.AppComponent
import com.kpstv.navigator_multimodule_test.di.AppComponentProvider
import com.kpstv.navigator_multimodule_test.di.DaggerAppComponent
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class App : Application(), AppComponentProvider {
  override val appComponent : AppComponent = DaggerAppComponent
    .factory().create(this)

//  @Inject lateinit var workerFactory: HiltWorkerFactory

//  override fun getWorkManagerConfiguration(): Configuration {
//    return Configuration.Builder().setWorkerFactory(workerFactory).build()
//  }

  override fun onCreate() {
    appComponent.inject(this)
    super.onCreate()
  }
}