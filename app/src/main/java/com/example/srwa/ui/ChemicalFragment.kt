package com.example.srwa.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.srwa.Adapter.Material
import com.example.srwa.Adapter.MaterialAdapter
import com.example.srwa.R


class ChemicalFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_chemical, container, false)

        // Inisialisasi RecyclerView
        val recyclerView: RecyclerView = view.findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = MaterialAdapter(generateDummyMaterials())

        return view
    }

    private fun generateDummyMaterials(): List<Material> {
        return listOf(
            Material("C01", "Dyes", "Dark Green", 20),
            Material("C02", "Dyes", "Black", 25),
            Material("C03", "Dyes", "Blue", 30),
            Material("C04", "Dyes", "White", 35),
            Material("C05", "Binders", "Grey", 40),
            Material("C06", "Bleaching Agents", "Grey", 40),

        )
    }
}