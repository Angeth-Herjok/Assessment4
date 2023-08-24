package com.example.asssessmentkotlin

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PostViewModel : ViewModel() {

    private val apiService = Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ApiResponse::class.java)

    val posts: MutableLiveData<List<Post>> = MutableLiveData()

    fun fetchPosts() {
        viewModelScope.launch {
            val response = apiService.getPosts()
            posts.value = response
        }
    }
}