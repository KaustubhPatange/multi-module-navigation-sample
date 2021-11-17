package com.kpstv.core.di.workmanager

import android.content.Context
import androidx.work.ListenableWorker
import androidx.work.WorkerParameters

interface DaggerWorkerFactory<T : ListenableWorker> {
  fun create(appContext: Context, params: WorkerParameters) : T
}
