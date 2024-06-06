package com.example.srwa.ui

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


class OutputFabricFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_output_fabric, container, false)

        // Inisialisasi RecyclerView
        val recyclerView: RecyclerView = view.findViewById(R.id.recycler_view_outputFabric)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = OutputMaterialAdapter(generateDummyMaterials())

        return view
    }

    private fun generateDummyMaterials(): List<outputMaterial> {
        return listOf(
            outputMaterial("F01", "Cotton", "White", 10),
            outputMaterial("F02", "Cotton", "Beige", 15),
            outputMaterial("F03", "Cotton", "Navy", 10),
            outputMaterial("F04", "Cotton", "Black", 15),
            outputMaterial("F05", "Denim", "Indigo Blue", 10),
            outputMaterial("F06", "Denim", "Black", 10),
            outputMaterial("F07", "Denim", "Light Blue", 15),
            outputMaterial("F08", "Polyester", "Dark Green", 10),
            outputMaterial("F09", "Polyester", "Black", 15),
            outputMaterial("F10", "Polyester", "Grey", 10),
            outputMaterial("F11", "Polyester", "Blue", 15),
            outputMaterial("F12", "Polyester", "White", 10)
        )
    }
}