package com.example.examenandroid.adapter

import com.example.examenandroid.model.Product
import com.example.examenandroid.model.ProductResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET("products/category/electronics")
    suspend fun getProductByCategory(

//        @Query("category") category: String
    ): Response<ProductResponse>


    @GET("/products/category/jewelery")
    suspend fun getProductJewelery(


    ): Response<ProductResponse>

    @GET("/products/category/men's%20clothing")
    suspend fun  getProductMensClothing(

    ): Response<ProductResponse>

    @GET("/products/category/women's%20clothing")
    suspend fun getProductWomenClothing(
      
    ): Response< ProductResponse>

    @GET("/products/7")
    suspend fun getProductById7(
//        @Query ("id") id: Int
    ): Response<ProductResponse>


}


