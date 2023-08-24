package com.example.asssessmentkotlin.Ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.asssessmentkotlin.Model.Post
import com.example.asssessmentkotlin.Model.PostAdapter
import com.example.asssessmentkotlin.ViewModel.PostViewModel
import com.example.asssessmentkotlin.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    val productViewModel: PostViewModel by viewModels()
    lateinit var binding: ActivityMainBinding
    lateinit var productAdapter: PostAdapter

    var productList: List<Post> = emptyList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        productAdapter = PostAdapter(emptyList())
    }

    override fun onResume() {
        super.onResume()
        productViewModel.fetchProducts()

        productViewModel.productsLiveData.observe(this, Observer { productList ->

            var productAdapter = PostAdapter(productList ?: emptyList())
            binding.rvProducts.layoutManager = GridLayoutManager(this, 2)
            binding.rvProducts.adapter = productAdapter
            Toast
                .makeText(baseContext, "fetched ${productList?.size}products", Toast.LENGTH_LONG)
                .show()

        })


        productViewModel.errorLiveData.observe(this, Observer { error ->

            Toast.makeText(baseContext, error, Toast.LENGTH_LONG).show()


        })
    }
}
