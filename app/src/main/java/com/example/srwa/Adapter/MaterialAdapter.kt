package com.example.srwa.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.srwa.R

data class Material(
    val id: String,
    val type: String,
    val color: String,
    val quantity: Int
)

class MaterialAdapter(private val materialList: List<Material>) :
    RecyclerView.Adapter<MaterialAdapter.MaterialViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MaterialViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_material, parent, false)
        return MaterialViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MaterialViewHolder, position: Int) {
        val currentItem = materialList[position]
        holder.idTextView.text = currentItem.id
        holder.typeTextView.text = currentItem.type
        holder.colorTextView.text = currentItem.color
        holder.quantityTextView.text = currentItem.quantity.toString()
    }

    override fun getItemCount() = materialList.size

    class MaterialViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val idTextView: TextView = itemView.findViewById(R.id.tv_id)
        val typeTextView: TextView = itemView.findViewById(R.id.tv_type)
        val colorTextView: TextView = itemView.findViewById(R.id.tv_color)
        val quantityTextView: TextView = itemView.findViewById(R.id.tv_qty)
    }
}
