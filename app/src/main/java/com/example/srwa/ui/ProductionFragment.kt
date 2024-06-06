package com.example.srwa.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import com.example.srwa.R


class ProductionFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_production, container, false)

        // Setup OnClickListeners for each CardView
        view.findViewById<CardView>(R.id.cardJackets).setOnClickListener {
            navigateToFragment(JacketsFragment())
        }

        view.findViewById<CardView>(R.id.cardShirts).setOnClickListener {
            navigateToFragment(ShirtsFragment())
        }

        view.findViewById<CardView>(R.id.cardPants).setOnClickListener {
            navigateToFragment(PantsFragment())
        }

        view.findViewById<CardView>(R.id.cardBags).setOnClickListener {
            navigateToFragment(BagsFragment())
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