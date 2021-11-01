package com.kpstv.home

import com.kpstv.home_internal.HomeButtonClicked
import com.kpstv.home_internal2.HomeInternal2Fragment
import javax.inject.Inject

class HomeButtonClickedImpl @Inject constructor(
  private val fragment: HomeFragment /* It is creating a new instance instead of providing an existing one */
) : HomeButtonClicked {
  override fun goToNext() {
    fragment.childFragmentManager.beginTransaction()
      .addToBackStack("home-internal2")
      .replace(R.id.frag_container, HomeInternal2Fragment::class.java, null)
      .commit()
  }
}