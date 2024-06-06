package com.example.srwa.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import com.example.srwa.R


class OutputProductFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_output_product, container, false)

        // Setup OnClickListeners for each CardView
        view.findViewById<CardView>(R.id.cardOutputJackets).setOnClickListener {
            navigateToFragment(OutputJacketsFragment())
        }

        view.findViewById<CardView>(R.id.cardOuputShirts).setOnClickListener {
            navigateToFragment(OutputShirtsFragment())
        }

        view.findViewById<CardView>(R.id.cardOutputPants).setOnClickListener {
            navigateToFragment(OutputPantsFragment())
        }

        view.findViewById<CardView>(R.id.cardOutputBags).setOnClickListener {
            navigateToFragment(OutputBagsFragment())
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