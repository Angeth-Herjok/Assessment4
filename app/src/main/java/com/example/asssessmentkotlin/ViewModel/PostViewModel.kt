package com.example.asssessmentkotlin.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.asssessmentkotlin.Model.Post
import com.example.asssessmentkotlin.Repository.PostRepository
import kotlinx.coroutines.launch

class PostViewModel : ViewModel() {
    val productsRepo = PostRepository()
    val productsLiveData = MutableLiveData<List<Post>>()
    val errorLiveData = MutableLiveData<String>()

    fun fetchProducts() {
        viewModelScope.launch {
            val response = productsRepo.getProducts()
            if (response.isSuccessful) {
                val productList=response.body()?: emptyList()
                productsLiveData.postValue(productList as
                        List<Post>)

            }
            else {
                errorLiveData.postValue(response.errorBody()?.string())
            }
        }
    }

}
