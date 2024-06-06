package com.example.srwa.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import com.example.srwa.R

class OutputMaterialFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_output_material, container, false)

        // Setup OnClickListeners for each CardView
        view.findViewById<CardView>(R.id.cardFabric).setOnClickListener {
            navigateToFragment(OutputFabricFragment())
        }

        view.findViewById<CardView>(R.id.cardYarn).setOnClickListener {
            navigateToFragment(OutputYarnFragment())
        }

        view.findViewById<CardView>(R.id.cardChino).setOnClickListener {
            navigateToFragment(OutputChinoFragment())
        }

        view.findViewById<CardView>(R.id.cardChemicals).setOnClickListener {
            navigateToFragment(OutputChemicalsFragment())
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