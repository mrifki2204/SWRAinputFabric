package com.example.srwa.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.srwa.R

class BoxAdapter(private val dataList: List<Pair<String, String>>) :
    RecyclerView.Adapter<BoxAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_box, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataList[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textLabel: TextView = itemView.findViewById(R.id.textLabel)
        private val textValue: TextView = itemView.findViewById(R.id.textValue)

        fun bind(data: Pair<String, String>) {
            textLabel.text = data.first
            textValue.text = data.second
        }
    }
}