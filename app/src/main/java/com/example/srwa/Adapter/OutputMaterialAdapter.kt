package com.example.srwa.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.srwa.R

data class outputMaterial(
    val id: String,
    val type: String,
    val color: String,
    val used: Int
)

class OutputMaterialAdapter (private val outputMaterialList: List<outputMaterial>) :
    RecyclerView.Adapter<OutputMaterialAdapter.MaterialViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MaterialViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_material_output, parent, false)
        return MaterialViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MaterialViewHolder, position: Int) {
        val currentItem = outputMaterialList[position]
        holder.idTextView.text = currentItem.id
        holder.typeTextView.text = currentItem.type
        holder.colorTextView.text = currentItem.color
        holder.usedTextView.text = currentItem.used.toString()
    }

    override fun getItemCount() = outputMaterialList.size

    class MaterialViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val idTextView: TextView = itemView.findViewById(R.id.tv_id)
        val typeTextView: TextView = itemView.findViewById(R.id.tv_type)
        val colorTextView: TextView = itemView.findViewById(R.id.tv_color)
        val usedTextView: TextView = itemView.findViewById(R.id.tv_used)
    }
    }