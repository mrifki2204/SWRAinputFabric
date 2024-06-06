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


class ChinoFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_chino, container, false)

        // Inisialisasi RecyclerView
        val recyclerView: RecyclerView = view.findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = MaterialAdapter(generateDummyMaterials())

        return view
    }

    private fun generateDummyMaterials(): List<Material> {
        return listOf(
            Material("A01", "Plastic Button", "Dark Green", 20),
            Material("A02", "Plastic Button", "Black", 25),
            Material("A03", "Material Button", "Blue", 30),
            Material("A04", "Material Button", "White", 35),
            Material("A05", "Wood Button", "Grey", 40),
            Material("A06", "Zippers", "White", 40),
            Material("A07", "Zippers", "Beige", 45),
            Material("A08", "Zippers", "Black", 50),
            Material("A09", "Woven Label", "Navy", 55),
            Material("A10", "Woven Label", "Beige", 60),

        )
    }
}