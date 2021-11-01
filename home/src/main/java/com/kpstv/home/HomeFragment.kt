package com.kpstv.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.kpstv.core.di.DaggerFragmentFactory
import com.kpstv.home.di.HomeComponent
import com.kpstv.home.di.HomeComponentProvider
import com.kpstv.home.fragments.HomeStartFragment
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.EntryPointAccessors
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment @Inject constructor() : Fragment(R.layout.fragment_home), HomeComponentProvider {

  override val homeComponent by lazy { EntryPointAccessors.fromFragment(this, HomeComponent::class.java) }

  @Inject
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