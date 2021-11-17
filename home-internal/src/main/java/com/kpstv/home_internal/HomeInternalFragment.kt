package com.kpstv.home_internal

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.kpstv.home_internal.worker.HomeInternalWorker
import javax.inject.Inject

class HomeInternalFragment @Inject constructor(
  private val homeButtonClicked: HomeButtonClicked,
) : Fragment(R.layout.fragment_home_internal) {

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    requireActivity().title = "Module: home-internal"

    val btnGoto = view.findViewById<Button>(R.id.btn_goto)
    btnGoto.setOnClickListener {
      homeButtonClicked.goToNext()
    }

    val workerStatus = view.findViewById<TextView>(R.id.tv_work_status)
    val btnWorker = view.findViewById<Button>(R.id.btn_work)

    workerStatus.text = getString(R.string.worker_status, "NOT STARTED")

    HomeInternalWorker.observe(requireContext()).observe(viewLifecycleOwner) { workInfos ->
      if (workInfos.isNotEmpty()) {
        val latestWork = workInfos.first()
        workerStatus.text = getString(R.string.worker_status, latestWork.state.name)
      }
    }

    btnWorker.setOnClickListener {
      HomeInternalWorker.schedule(requireContext())
    }
  }
}