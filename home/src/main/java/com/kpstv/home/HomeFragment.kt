package com.kpstv.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.kpstv.core.di.DaggerFragmentFactory
import com.kpstv.home.di.HomeComponent
import com.kpstv.home.di.HomeComponentProvider
import com.kpstv.home.di.HomeScope
import com.kpstv.home.fragments.HomeStartFragment
import javax.inject.Inject

class HomeFragment @Inject constructor(
  homeComponentFactory: HomeComponent.Factory
) : Fragment(R.layout.fragment_home), HomeComponentProvider {

  override val homeComponent = homeComponentFactory.create(this)

  // if constructor injected then the fragment multi-bindings will be provided from
  // activityComponent i.e only WelcomeFragment & HomeFragment but we also
  // want all from the HomeFragmentModule. Hence field injection to inject from HomeComponent.
  @HomeScope @Inject
  lateinit var fragmentFactory: DaggerFragmentFactory

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    homeComponent.inject(this)
    super.onViewCreated(view, savedInstanceState)
    childFragmentManager.fragmentFactory = fragmentFactory

    requireActivity().title = "Module: home"

    childFragmentManager.beginTransaction()
      .replace(view.id, HomeStartFragment::class.java, null)
      .commit()
  }
}