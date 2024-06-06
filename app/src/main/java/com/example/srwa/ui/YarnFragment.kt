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


class YarnFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_yarn, container, false)

        // Inisialisasi RecyclerView
        val recyclerView: RecyclerView = view.findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = MaterialAdapter(generateDummyMaterials())

        return view
    }

    private fun generateDummyMaterials(): List<Material> {
        return listOf(
            Material("Y01", "Polyester Yarn", "Dark Green", 20),
            Material("Y02", "Polyester Yarn", "Black", 25),
            Material("Y03", "Polyester Yarn", "Blue", 30),
            Material("Y04", "Polyester Yarn", "White", 35),
            Material("Y05", "Polyester Yarn", "Grey", 40),
            Material("Y06", "Cotton Yarn", "White", 40),
            Material("Y07", "Cotton Yarn", "Beige", 45),
            Material("Y08", "Cotton Yarn", "Black", 50),
            Material("Y09", "Cotton Yarn", "Navy", 55),
            Material("Y10", "Nylon Yarn", "Beige", 60),
            Material("Y11", "Nylon Yarn", "Black", 65),
            Material("Y12","Nylon Yarn","Navy",60)

        )
    }
}