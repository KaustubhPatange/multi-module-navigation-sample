package com.kpstv.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.kpstv.core.HomeScope
import com.kpstv.core.SomeDependency
import com.kpstv.home.fragments.HomeStartFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {

  @Inject lateinit var homeDependency : HomeDependency

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    requireActivity().title = "Module: home"

    homeDependency.call("home")

    childFragmentManager.beginTransaction()
      .replace(view.id, HomeStartFragment::class.java, null)
      .commit()
  }
}