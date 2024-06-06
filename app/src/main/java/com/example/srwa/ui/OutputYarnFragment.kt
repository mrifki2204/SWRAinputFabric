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


class OutputYarnFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_output_yarn, container, false)

        // Inisialisasi RecyclerView
        val recyclerView: RecyclerView = view.findViewById(R.id.recycler_view_outputYarn)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = OutputMaterialAdapter(generateDummyMaterials())

        return view
    }

    private fun generateDummyMaterials(): List<outputMaterial> {
        return listOf(
            outputMaterial("Y01", "Polyester Yarn", "Dark Green", 5),
            outputMaterial("Y02", "Polyester Yarn", "Black", 10),
            outputMaterial("Y03", "Polyester Yarn", "Blue", 2),
            outputMaterial("Y04", "Polyester Yarn", "White", 5),
            outputMaterial("Y05", "Polyester Yarn", "Grey", 2),
            outputMaterial("Y06", "Cotton Yarn", "White", 5),
            outputMaterial("Y07", "Cotton Yarn", "Beige", 4),
            outputMaterial("Y08", "Cotton Yarn", "Black", 10),
            outputMaterial("Y09", "Cotton Yarn", "Navy", 10),
            outputMaterial("Y10", "Nylon Yarn", "Beige", 2),
            outputMaterial("Y11", "Nylon Yarn", "Black", 4),
            outputMaterial("Y12","Nylon Yarn","Navy",5)

        )
    }
}