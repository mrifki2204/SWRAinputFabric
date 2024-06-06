package com.example.srwa.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.srwa.R

data class outputProduct(
    val id: String,
    val type: String,
    val color: String,
    val size: String,
    val packing: Int
)

class OutputProductAdapter(private val outputProductList: List<outputProduct>) :
    RecyclerView.Adapter<OutputProductAdapter.MaterialViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MaterialViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_product_output, parent, false)
        return MaterialViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MaterialViewHolder, position: Int) {
        val currentItem = outputProductList[position]
        holder.idTextView.text = currentItem.id
        holder.typeTextView.text = currentItem.type
        holder.colorTextView.text = currentItem.color
        holder.sizeTextView.text = currentItem.size
        holder.packingTextView.text = currentItem.packing.toString()
    }

    override fun getItemCount() = outputProductList.size

    class MaterialViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val idTextView: TextView = itemView.findViewById(R.id.tv_id)
        val typeTextView: TextView = itemView.findViewById(R.id.tv_type)
        val colorTextView: TextView = itemView.findViewById(R.id.tv_color)
        val sizeTextView: TextView = itemView.findViewById(R.id.tv_size)
        val packingTextView: TextView = itemView.findViewById(R.id.tv_packing)
    }
}

