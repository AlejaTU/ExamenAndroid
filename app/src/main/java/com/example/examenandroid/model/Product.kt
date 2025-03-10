package com.example.examenandroid.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ProductResponse (
    @SerializedName("") val results: List<Product>,
): Serializable

data class Product (
    val id: Int,
    val title: String,
    val price: Double,
    val description: String,
    val category: String,
    val image: String
): Serializable




