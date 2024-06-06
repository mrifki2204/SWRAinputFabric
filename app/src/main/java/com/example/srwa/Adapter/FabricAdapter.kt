package com.example.srwa.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.srwa.Model.Fabric
import com.example.srwa.R

class FabricAdapter(private val fabricList: ArrayList<Fabric>) : RecyclerView.Adapter<FabricAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val id: TextView = itemView.findViewById(R.id.textViewId)
        val type: TextView = itemView.findViewById(R.id.textViewType)
        val color: TextView = itemView.findViewById(R.id.textViewColor)
        val quantity: TextView = itemView.findViewById(R.id.textViewQuantity)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fabric_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val fabric = fabricList[position]
        holder.id.text = fabric.id
        holder.type.text = fabric.type
        holder.color.text = fabric.color
        holder.quantity.text = fabric.qty.toString()
    }

    override fun getItemCount(): Int {
        return fabricList.size
    }
}
