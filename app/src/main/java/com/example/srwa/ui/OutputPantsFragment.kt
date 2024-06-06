package com.example.srwa.ui

import android.annotation.SuppressLint
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

class OutputPantsFragment : Fragment() {
    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_output_pants, container, false)

        // Inisialisasi RecyclerView
        val recyclerView: RecyclerView = view.findViewById(R.id.recycler_view_ouputpants)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = OutputProductAdapter(generateDummyMaterials())

        return view
    }

    private fun generateDummyMaterials(): List<outputProduct> {
        return listOf(
            outputProduct("C01", "Chinos", "Black", "M", 12),
            outputProduct("C02", "Chinos", "Grey", "L", 12),
            outputProduct("C03", "Cargo", "Black", "XL", 12),
            outputProduct("C04", "Cargo", "Indigo Blue", "M", 12),
            outputProduct("C05", "Cargo", "Blue", "L", 12),
            outputProduct("C06", "Cargo", "Balck", "XL", 12),
            outputProduct("C07", "Jeans", "Black", "M", 12),
            outputProduct("C08", "Jeans", "Navy", "L", 12),
            outputProduct("C09", "Jeans", "Light Blue", "M", 12),
            outputProduct("C10", "Jeans", "Grey", "M", 12),
            outputProduct("C11", "Cargo", "Navy", "L", 12),
            outputProduct("C12", "Cargo", "Green", "XL", 12),

            )
    }
}