package com.example.examenandroid.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.examenandroid.databinding.ProductDetailActivityBinding

class ProductDetailActivity: AppCompatActivity() {

    private lateinit var binding: ProductDetailActivityBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding = ProductDetailActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)





    }
}