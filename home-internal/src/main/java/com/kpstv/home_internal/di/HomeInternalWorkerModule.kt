package com.kpstv.home_internal.di

import androidx.work.ListenableWorker
import com.kpstv.core.di.WorkerKey
import com.kpstv.core.di.workmanager.DaggerWorkerFactory
import com.kpstv.home_internal.worker.HomeInternalWorker
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class HomeInternalWorkerModule {
  @Binds
  @IntoMap
  @WorkerKey(HomeInternalWorker::class)
  abstract fun homeInternalWorker(factory: HomeInternalWorker.Factory) : DaggerWorkerFactory<out ListenableWorker>
}