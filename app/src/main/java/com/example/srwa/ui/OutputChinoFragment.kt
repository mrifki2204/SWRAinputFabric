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

class OutputChinoFragment : Fragment() {
    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_output_chino, container, false)

        // Inisialisasi RecyclerView
        val recyclerView: RecyclerView = view.findViewById(R.id.recycler_view_outputChino)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = OutputMaterialAdapter(generateDummyMaterials())

        return view
    }

    private fun generateDummyMaterials(): List<outputMaterial> {
        return listOf(
            outputMaterial("A01", "Plastic Button", "Dark Green", 10),
            outputMaterial("A02", "Plastic Button", "Black", 15),
            outputMaterial("A03", "Material Button", "Blue", 10),
            outputMaterial("A04", "Material Button", "White", 15),
            outputMaterial("A05", "Wood Button", "Grey", 20),
            outputMaterial("A06", "Zippers", "White", 20),
            outputMaterial("A07", "Zippers", "Beige", 15),
            outputMaterial("A08", "Zippers", "Black", 10),
            outputMaterial("A09", "Woven Label", "Navy", 15),
            outputMaterial("A10", "Woven Label", "Beige", 16),
        )
    }
}