package com.example.srwa.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.srwa.Adapter.BoxAdapter
import com.example.srwa.R
import com.example.srwa.activity.LoginActivity
import com.example.srwa.databinding.FragmentDashboardBinding
import com.google.firebase.auth.FirebaseAuth
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.components.Description
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import android.graphics.Color
import androidx.core.content.ContextCompat

class DashboardFragment : Fragment() {

    private lateinit var textFullName: TextView
    private lateinit var textEmail: TextView
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: BoxAdapter
    private var firebaseAuth = FirebaseAuth.getInstance()
    private val binding by lazy { FragmentDashboardBinding.inflate(layoutInflater) }
    private lateinit var barChart: BarChart

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_dashboard, container, false)
        textFullName = view.findViewById(R.id.username)
        textEmail = view.findViewById(R.id.gmail)
        recyclerView = view.findViewById(R.id.recyclerView)
        barChart = view.findViewById(R.id.barChart)

        setupBarChart()
        loadBarChartData()

        // Configure RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        val dataList = listOf(
            Pair("Input", "200"),
            Pair("Production", "300"),
            Pair("Output", "500")
        )
        adapter = BoxAdapter(dataList)
        recyclerView.adapter = adapter

        // Check if user is logged in
        val firebaseUser = firebaseAuth.currentUser
        if (firebaseUser != null) {
            textFullName.text = firebaseUser.displayName
            textEmail.text = firebaseUser.email
        } else {
            // If not logged in, navigate to LoginActivity
            startActivity(Intent(requireContext(), LoginActivity::class.java))
            requireActivity().finish()
        }

        return view
    }

    private fun setupBarChart() {
        barChart.setDrawBarShadow(false)
        barChart.setDrawValueAboveBar(true)
        barChart.setMaxVisibleValueCount(50)
        barChart.setPinchZoom(false)
        barChart.setDrawGridBackground(false)

        val description = Description()
        description.text = "Monthly Wirehouse"
        description.textColor = Color.WHITE
        barChart.description = description
    }

    private fun loadBarChartData() {
        val entries = ArrayList<BarEntry>()
        entries.add(BarEntry(1f, 4f))
        entries.add(BarEntry(2f, 8f))
        entries.add(BarEntry(3f, 6f))
        entries.add(BarEntry(4f, 2f))
        entries.add(BarEntry(5f, 5f))

        val barDataSet = BarDataSet(entries, "Data Set")
        barDataSet.colors = listOf(ContextCompat.getColor(requireContext(), R.color.orange))
        barDataSet.valueTextColor = Color.WHITE
        barDataSet.valueTextSize = 16f

        val data = BarData(barDataSet)
        barChart.data = data
        barChart.invalidate() // refresh
    }
}
