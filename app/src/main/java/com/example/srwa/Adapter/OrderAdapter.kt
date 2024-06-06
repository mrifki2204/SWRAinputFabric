package com.example.srwa.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.srwa.R

data class Order(
    val orderId: String,
    val orderDate: String,
    val orderStatus: String,
    val shippingDestination: String
)

// Adapter for RecyclerView to display order items
class OrderAdapter(private val orders: List<Order>) :
    RecyclerView.Adapter<OrderAdapter.OrderViewHolder>() {

    inner class OrderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvOrderId: TextView = itemView.findViewById(R.id.orderID)
        val tvOrderDate: TextView = itemView.findViewById(R.id.orderDate)
        val tvOrderStatus: TextView = itemView.findViewById(R.id.orderStatus)
        val tvShippingDestination: TextView = itemView.findViewById(R.id.shippingDestination)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_order, parent, false)
        return OrderViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: OrderViewHolder, position: Int) {
        val order = orders[position]
        holder.tvOrderId.text = order.orderId
        holder.tvOrderDate.text = order.orderDate
        holder.tvOrderStatus.text = order.orderStatus
        holder.tvShippingDestination.text = order.shippingDestination
    }

    override fun getItemCount(): Int {
        return orders.size
    }
}