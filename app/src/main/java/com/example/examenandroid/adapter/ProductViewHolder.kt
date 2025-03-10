package com.example.examenandroid.adapter

import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.example.examenandroid.databinding.ItemProductBinding
import com.example.examenandroid.model.Product
import com.squareup.picasso.Picasso

class ProductViewHolder(private val binding: ItemProductBinding): RecyclerView.ViewHolder(binding.root){

    fun bind(product: Product) {
        binding.tvTitle.text = product.title
        Picasso.get()
            .load("https://fakestoreapi.com/img/${product.image}")
            .into(binding.imgProducto)
    }

}

