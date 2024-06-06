package com.example.srwa.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.srwa.Adapter.Order
import com.example.srwa.Adapter.Product
import com.example.srwa.Adapter.ProductAdapter
import com.example.srwa.R


class OrderKickoutFragment : Fragment() {

    private lateinit var order: Order

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_order_kickout, container, false)

        // Inisialisasi RecyclerView
        val recyclerView: RecyclerView = view.findViewById(R.id.recycler_view_product)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = ProductAdapter(generateDummyMaterials())

        // Inisialisasi data order
        order = Order(
            orderId = "KCK22122023",
            orderDate = "22/12/2023",
            orderStatus = "Processing",
            shippingDestination = "Kickout Store, Malang, East Java"
        )

        // Set text to TextViews in the layout
        view.findViewById<TextView>(R.id.orderIdValueTextView).text = order.orderId
        view.findViewById<TextView>(R.id.orderDateValueTextView).text = order.orderDate
        view.findViewById<TextView>(R.id.orderStatusValueTextView).text = order.orderStatus
        view.findViewById<TextView>(R.id.shippingDestinationValueTextView).text =
            order.shippingDestination

        return view
    }
    private fun generateDummyMaterials(): List<Product> {
        return listOf(
            Product("CN01","Chino", "Casual", "Beige", "M", 48),
            Product("CN02","Chino", "Casual", "Beige", "L", 48),
            Product("CN03","Chino", "Casual", "Beige", "XL", 48),
            Product("CN04","Cargo", "Casual", "Navy", "M", 48),
            Product("CN05","Cargo", "Casual", "Navy", "L", 48),
            Product("CN06","Cargo", "Casual", "Navy", "XL", 48)
        )
    }
}