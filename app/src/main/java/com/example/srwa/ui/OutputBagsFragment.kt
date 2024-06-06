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


class OutputBagsFragment : Fragment() {
    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_output_bags, container, false)

        // Inisialisasi RecyclerView
        val recyclerView: RecyclerView = view.findViewById(R.id.recycler_view_ouputBags)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = OutputProductAdapter(generateDummyMaterials())

        return view
    }

    private fun generateDummyMaterials(): List<outputProduct> {
        return listOf(
            outputProduct("B01", "Handbag", "Black", "M", 12),
            outputProduct("B02", "Handbag", "Grey", "L", 12),
            outputProduct("B03", "BackPack", "Black", "XL", 12),
            outputProduct("B04", "Handbag", "Indigo Blue", "M", 12),
            outputProduct("B05", "Tote Bag", "Blue", "L", 12),
            outputProduct("B06", "Tote Bag", "Black", "XL", 12),
            outputProduct("B07", "Waist Bag", "Black", "M", 12),
            outputProduct("B08", "Waist Bag", "Navy", "L", 12),
            outputProduct("B09", "Waist Bag", "Light Blue", "M", 12),
            outputProduct("B10", "Waist Bag", "Grey", "M", 12),
            outputProduct("B11", "Shoulder Bag", "Navy", "L", 12),
            outputProduct("B12", "Shoulder Bag", "Green", "XL", 12),

            )
    }
}