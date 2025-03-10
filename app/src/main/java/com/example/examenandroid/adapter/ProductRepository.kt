package com.example.examenandroid.adapter

import com.example.examenandroid.model.ProductResponse
import retrofit2.Response

class ProductRepository(private val service: Api) {

    suspend fun getProductByCategory(): Response<ProductResponse> =
        service.getProductByCategory()

    suspend fun getProductJewelery(): Response<ProductResponse> =
        service.getProductJewelery()

    suspend fun getProductMensClothing(): Response<ProductResponse> =
        service.getProductMensClothing()

    suspend fun getProductWomenClothing(): Response<ProductResponse> =
        service.getProductWomenClothing()
    suspend fun getProductById7(): Response<ProductResponse> =
        service.getProductById7()

}




