package com.example.srwa.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.srwa.Adapter.OutputProductAdapter
import com.example.srwa.Adapter.outputProduct
import com.example.srwa.R


class OutputJacketsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_output_jackets, container, false)

        // Inisialisasi RecyclerView
        val recyclerView: RecyclerView = view.findViewById(R.id.recycler_view_ouputJackets)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = OutputProductAdapter(generateDummyMaterials())

        return view
    }

    private fun generateDummyMaterials(): List<outputProduct> {
        return listOf(
            outputProduct("J01", "Hoddie", "Black", "M", 12),
            outputProduct("J02", "Hoddie", "Black", "L", 12),
            outputProduct("J03", "Hoddie", "Black", "XL", 12),
            outputProduct("J04", "Hoddie", "White", "M", 12),
            outputProduct("J05", "Hoddie", "White", "L", 12),
            outputProduct("J06", "Hoddie", "White", "XL", 12),
            outputProduct("J07", "Denim", "Black", "M", 12),
            outputProduct("J08", "Denim", "Black", "L", 12),
            outputProduct("J09", "Denim", "Black", "M", 12),
            outputProduct("J10", "Denim", "Light Blue", "M", 12),
            outputProduct("J11", "Denim", "Light Blue", "L", 12),
            outputProduct("J12", "Denim", "Light Blue", "XL", 12),

        )
    }
}