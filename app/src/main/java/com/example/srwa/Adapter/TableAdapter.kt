package com.example.srwa.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.srwa.R

data class Item(
    val id: String,
    val type: String,
    val color: String,
    val quantity: Int
)

class TableAdapter(private val items: List<Item>) :
    RecyclerView.Adapter<TableAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvId: TextView = itemView.findViewById(R.id.tv_id)
        val tvType: TextView = itemView.findViewById(R.id.tv_type)
        val tvColor: TextView = itemView.findViewById(R.id.tv_color)
        val tvQuantity: TextView = itemView.findViewById(R.id.tv_qty)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_table_row, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.tvId.text = item.id
        holder.tvType.text = item.type
        holder.tvColor.text = item.color
        holder.tvQuantity.text = item.quantity.toString()
    }

    override fun getItemCount() = items.size
}
