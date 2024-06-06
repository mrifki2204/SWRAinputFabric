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


class OutputShirtsFragment : Fragment() {
    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_output_shirts, container, false)

        // Inisialisasi RecyclerView
        val recyclerView: RecyclerView = view.findViewById(R.id.recycler_view_ouputShirts)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = OutputProductAdapter(generateDummyMaterials())

        return view
    }

    private fun generateDummyMaterials(): List<outputProduct> {
        return listOf(
            outputProduct("S01", "Kaos", "Black", "M", 12),
            outputProduct("S02", "Kaos", "Grey", "L", 12),
            outputProduct("S03", "Kaos", "Black", "XL", 12),
            outputProduct("S04", "Kemeja", "Indigo Blue", "M", 12),
            outputProduct("S05", "Kemeja", "Blue", "L", 12),
            outputProduct("S06", "Kemeja", "Black", "XL", 12),
            outputProduct("S07", "Jeans", "Black", "M", 12),
            outputProduct("S08", "Jeans", "Navy", "L", 12),
            outputProduct("S09", "Jeans", "Light Blue", "M", 12),
            outputProduct("S10", "Jeans", "Grey", "M", 12),
            outputProduct("S11", "Jas", "Navy", "L", 12),
            outputProduct("S12", "Jas", "Green", "XL", 12),

            )
    }
}