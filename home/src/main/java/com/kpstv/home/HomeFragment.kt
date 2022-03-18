package com.kpstv.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.kpstv.core.di.DaggerFragmentFactory
import com.kpstv.home.di.HomeComponent
import com.kpstv.home.di.HomeComponentProvider
import com.kpstv.home.fragments.HomeStartFragment
import javax.inject.Inject

class HomeFragment @Inject constructor(
  homeComponentFactory: HomeComponent.Factory
) : Fragment(R.layout.fragment_home), HomeComponentProvider {

  override val homeComponent = homeComponentFactory.create(this)

  // if constructor injected then the fragment multi-bindings will be provided from
  // activityComponent i.e only WelcomeFragment & HomeFragment but we also
  // want all from the HomeFragmentModule. Hence field injection to inject from HomeComponent.
  @Inject
  lateinit var fragmentFactory: DaggerFragmentFactory

  override fun onCreate(savedInstanceState: Bundle?) {
    homeComponent.inject(this)
    childFragmentManager.fragmentFactory = fragmentFactory
    super.onCreate(savedInstanceState)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    requireActivity().title = "Module: home"

    if (savedInstanceState == null) {
      childFragmentManager.beginTransaction()
        .replace(view.id, HomeStartFragment::class.java, null)
        .commit()
    }
  }
}