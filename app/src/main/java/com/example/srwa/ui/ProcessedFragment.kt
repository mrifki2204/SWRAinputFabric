package com.example.srwa.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import com.example.srwa.R


class ProcessedFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_processed, container, false)

        // Setup OnClickListeners for each CardView
        view.findViewById<CardView>(R.id.cardErigo).setOnClickListener {
            navigateToFragment(OrderErigoFragment())
        }

        view.findViewById<CardView>(R.id.cardCrooz).setOnClickListener {
            navigateToFragment(OrderCroozFragment())
        }

        view.findViewById<CardView>(R.id.cardHeyho).setOnClickListener {
            navigateToFragment(OrderHeyhoFragment())
        }

        view.findViewById<CardView>(R.id.cardKickout).setOnClickListener {
            navigateToFragment(OrderKickoutFragment())
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