package com.kpstv.home.fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.kpstv.home.HomeDependency
import com.kpstv.home.R
import com.kpstv.home_internal.HomeInternalFragment
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

class HomeStartFragment @Inject constructor(
  private val homeDependency: HomeDependency
) : Fragment(R.layout.fragment_home_start) {
  private val viewModel by viewModels<HomeStartViewModel>()

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    homeDependency.call() // constructor injected dependency

    val stateTextView = view.findViewById<TextView>(R.id.tv_state)
    val button = view.findViewById<Button>(R.id.btn_goto)

    viewLifecycleOwner.lifecycleScope.launchWhenStarted {
      viewModel.state.collect { state ->
        stateTextView.text = getString(R.string.state, state.text)
        button.isEnabled = state.enabled
      }
    }

    button.setOnClickListener {
      // this could be done better but for the sake of simplicity keep it as it is.
      requireParentFragment().childFragmentManager.beginTransaction()
        .addToBackStack("homeinternal")
        .replace(R.id.frag_container, HomeInternalFragment::class.java, null)
        .commit()
    }
  }
}