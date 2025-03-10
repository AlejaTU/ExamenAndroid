package com.example.examenandroid.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.examenandroid.databinding.ItemProductBinding
import com.example.examenandroid.model.Product
import com.example.examenandroid.view.ProductDetailActivity

class ProductAdapter(private var products: List<Product>): RecyclerView.Adapter<ProductViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding = ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = products[position]
        holder.bind(product)
        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, ProductDetailActivity::class.java)
            intent.putExtra("product", product)
            context.startActivity(intent)

        }

    }

        override fun getItemCount(): Int = products.size

    //actualizar productos
    fun updateProducts(newProducts: List<Product>) {
        products = newProducts
        notifyDataSetChanged()

    }
    }

