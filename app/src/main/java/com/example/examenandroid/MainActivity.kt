package com.example.examenandroid

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.examenandroid.adapter.Api
import com.example.examenandroid.adapter.ProductAdapter
import com.example.examenandroid.adapter.ProductRepository
import com.example.examenandroid.databinding.ActivityMainBinding
import com.example.examenandroid.viewmodel.ProductCategory
import com.example.examenandroid.viewmodel.ProductViewModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: ProductAdapter
    private lateinit var viewModel: ProductViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //cargar la toolbar
        setSupportActionBar(binding.toolbarStore)


        //cargar recycler
        //configurar recycler view
        adapter = ProductAdapter(emptyList())
        binding.rvListaProductos.layoutManager = LinearLayoutManager(this)
        binding.rvListaProductos.adapter = adapter


        //configurar retrofit

        val retrofit = Retrofit.Builder()
            .baseUrl("https://fakestoreapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        //creamos el serivicio de tmdb y repositorio encapsula las llamadas a la api
        val service = retrofit.create(Api::class.java)
        //reemplazamos la api key
        val repository = ProductRepository(service)

        viewModel = ViewModelProvider(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return ProductViewModel(repository) as T
            }
        }).get(ProductViewModel::class.java)

        //observar productos
        viewModel.products.observe(this, Observer { products ->
            adapter.updateProducts(products)
        })
        viewModel.loadProducts(ProductCategory.ELECTRONICS)
    }


}
