package com.example.srwa.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.srwa.R

data class Product(
    val id: String,
    val product: String,
    val type: String,
    val color: String,
    val size: String,
    val qty: Int
)

class ProductAdapter(private val productList: List<Product>) :
    RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    inner class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val idTextView: TextView = itemView.findViewById(R.id.productIdTextView)
        val nameTextView: TextView = itemView.findViewById(R.id.productNameTextView)
        val typeTextView: TextView = itemView.findViewById(R.id.productTypeTextView)
        val colorTextView: TextView = itemView.findViewById(R.id.productColorTextView)
        val sizeTextView: TextView = itemView.findViewById(R.id.productSizeTextView)
        val qtyTextView: TextView = itemView.findViewById(R.id.productQtyTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_product, parent, false)
        return ProductViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = productList[position]

        holder.idTextView.text = product.id
        holder.nameTextView.text = product.product
        holder.typeTextView.text = product.type
        holder.colorTextView.text = product.color
        holder.sizeTextView.text = product.size
        holder.qtyTextView.text = product.qty.toString()
    }

    override fun getItemCount(): Int {
        return productList.size
    }
}