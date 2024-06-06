package com.example.srwa.ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.srwa.Adapter.OutputMaterialAdapter
import com.example.srwa.Adapter.outputMaterial
import com.example.srwa.R


class OutputChemicalsFragment : Fragment() {
    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_output_chemicals, container, false)

        // Inisialisasi RecyclerView
        val recyclerView: RecyclerView = view.findViewById(R.id.recycler_view_outputChemicals)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = OutputMaterialAdapter(generateDummyMaterials())

        return view
    }

    private fun generateDummyMaterials(): List<outputMaterial> {
        return listOf(
            outputMaterial("C01", "Dyes", "Dark Green", 10),
            outputMaterial("C02", "Dyes", "Black", 15),
            outputMaterial("C03", "Dyes", "Blue", 15),
            outputMaterial("C04", "Dyes", "White", 5),
            outputMaterial("C05", "Binders", "Grey", 10),
            outputMaterial("C06", "Bleaching Agents", "Grey", 10),

            )
    }
}