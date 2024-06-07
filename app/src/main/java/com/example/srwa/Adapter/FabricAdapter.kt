package com.example.srwa.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.srwa.Model.Fabric
import com.example.srwa.R
import com.example.srwa.activity.EditFabricActivity
import com.google.firebase.database.FirebaseDatabase

class FabricAdapter(private val fabricList: ArrayList<Fabric>, private val context: Context) : RecyclerView.Adapter<FabricAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val id: TextView = itemView.findViewById(R.id.textViewId)
        val type: TextView = itemView.findViewById(R.id.textViewType)
        val color: TextView = itemView.findViewById(R.id.textViewColor)
        val quantity: TextView = itemView.findViewById(R.id.textViewQuantity)
        val editButton: Button = itemView.findViewById(R.id.buttonEdit)
        val deleteButton: Button = itemView.findViewById(R.id.buttonDelete)
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

        holder.deleteButton.setOnClickListener {
            deleteFabric(fabric)
        }

        holder.editButton.setOnClickListener {
            val intent = Intent(context, EditFabricActivity::class.java).apply {
                putExtra("fabricId", fabric.id)
            }
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return fabricList.size
    }

    private fun deleteFabric(fabric: Fabric) {
        val database = FirebaseDatabase.getInstance().reference.child("fabrics").child(fabric.id)
        database.removeValue()
            .addOnSuccessListener {
                Toast.makeText(context, "Fabric deleted successfully", Toast.LENGTH_SHORT).show()
                fabricList.remove(fabric)
                notifyDataSetChanged()
            }
            .addOnFailureListener {
                Toast.makeText(context, "Failed to delete fabric", Toast.LENGTH_SHORT).show()
            }
    }
}
