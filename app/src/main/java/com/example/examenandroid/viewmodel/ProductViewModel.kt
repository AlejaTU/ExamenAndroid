package com.example.examenandroid.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.examenandroid.adapter.ProductRepository
import com.example.examenandroid.model.Product
import com.example.examenandroid.model.ProductResponse
import kotlinx.coroutines.launch
import retrofit2.Response


enum class ProductCategory {
    ELECTRONICS, JEWELERY, MEN_CLOTHING, WOMEN_CLOTHING
}



class ProductViewModel(private val repository: ProductRepository) : ViewModel() {


private val _products = MutableLiveData<List<Product>>()
    val products: LiveData<List<Product>> get() = _products

    //cargar productos segun categoria
    fun loadProducts(category: ProductCategory) {
        viewModelScope.launch {
            val response: Response<ProductResponse> = when (category) {
                ProductCategory.ELECTRONICS -> repository.getProductByCategory()
                ProductCategory.JEWELERY -> repository.getProductJewelery()
                ProductCategory.MEN_CLOTHING -> repository.getProductMensClothing()
                ProductCategory.WOMEN_CLOTHING -> repository.getProductWomenClothing()


        }
            if(response.isSuccessful) {
                _products.postValue(response.body()?.results ?: emptyList())
            } else {
                _products.postValue(emptyList())

    }

}
    }
}