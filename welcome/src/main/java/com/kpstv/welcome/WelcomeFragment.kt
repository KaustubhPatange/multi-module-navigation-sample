package com.kpstv.welcome

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.kpstv.core.SomeDependency
import javax.inject.Inject

class WelcomeFragment @Inject constructor(
  private val someDependency: SomeDependency,
  private val welcomeButtonClick: WelcomeButtonClick
) : Fragment(R.layout.fragment_welcome) {

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    requireActivity().title = "Module: welome"

    val textView = view.findViewById<TextView>(R.id.textView)
    textView.text = "${someDependency.getData(100)}"

    val button = view.findViewById<Button>(R.id.btn)
    button.setOnClickListener {
      welcomeButtonClick.goToNext()
    }
  }
}