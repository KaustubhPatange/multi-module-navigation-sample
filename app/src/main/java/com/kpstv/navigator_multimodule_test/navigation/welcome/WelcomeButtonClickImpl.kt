package com.kpstv.navigator_multimodule_test.navigation.welcome

import androidx.fragment.app.FragmentActivity
import com.kpstv.home.HomeFragment
import com.kpstv.navigator_multimodule_test.R
import com.kpstv.welcome.WelcomeButtonClick
import javax.inject.Inject

class WelcomeButtonClickImpl @Inject constructor(
  private val activity: FragmentActivity /* Provides the nearest fragment activity */
) : WelcomeButtonClick {
  override fun goToNext() {
    activity.supportFragmentManager.beginTransaction()
      .addToBackStack("home")
      .replace(R.id.frag_container, HomeFragment::class.java, null)
      .commit()
  }
}