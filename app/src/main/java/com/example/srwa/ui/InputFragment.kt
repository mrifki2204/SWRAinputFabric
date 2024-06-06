package com.example.srwa.ui

import android.os.Bundle
import android.text.TextUtils.replace
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import com.example.srwa.R
import androidx.fragment.app.Fragment
import com.example.warehouseapp.ui.FabricFragment

class InputFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_input, container, false)

        // Setup OnClickListeners for each CardView
        view.findViewById<CardView>(R.id.fabric).setOnClickListener {
            navigateToFragment(FabricFragment())
        }

        view.findViewById<CardView>(R.id.yarn).setOnClickListener {
            navigateToFragment(YarnFragment())
        }

        view.findViewById<CardView>(R.id.chino).setOnClickListener {
            navigateToFragment(ChinoFragment())
        }

        view.findViewById<CardView>(R.id.chemicals).setOnClickListener {
            navigateToFragment(ChemicalFragment())
        }

        return view
    }

    private fun navigateToFragment(fragment: Fragment) {
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(null)
            .commit()
    }
}