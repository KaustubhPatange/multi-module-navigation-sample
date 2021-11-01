package com.kpstv.navigator_multimodule_test

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.kpstv.core.di.DaggerFragmentFactory
import com.kpstv.navigator_multimodule_test.databinding.ActivityMainBinding
import com.kpstv.navigator_multimodule_test.di.AppComponentProvider
import com.kpstv.welcome.WelcomeFragment
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

  private lateinit var binding: ActivityMainBinding

  @Inject lateinit var daggerFragmentFactory: DaggerFragmentFactory

  override fun onCreate(savedInstanceState: Bundle?) {
    (application as AppComponentProvider)
      .appComponent.activityComponent().activity(this)
      .inject(this)
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)

    setSupportActionBar(binding.toolbar)

    supportFragmentManager.fragmentFactory = daggerFragmentFactory
    supportFragmentManager.beginTransaction()
      .replace(R.id.frag_container, WelcomeFragment::class.java, null)
      .commit()

  }

  override fun onBackPressed() {
    val fm: FragmentManager = supportFragmentManager
    for (frag in fm.fragments) {
      if (frag.isVisible) {
        val childFm: FragmentManager = frag.childFragmentManager
        if (childFm.backStackEntryCount > 0) {
          childFm.popBackStack()
          return
        }
      }
    }
    super.onBackPressed()
  }
}