package com.example.asssessmentkotlin.Repository


import com.example.asssessmentkotlin.Api.ApiClient
import com.example.asssessmentkotlin.Api.ApiInterface
import com.example.asssessmentkotlin.Model.Post
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class PostRepository {
    val apiClient = ApiClient.buildClient(ApiInterface::class.java)

    suspend fun getProducts(): Response<List<Post>> {
        return withContext(Dispatchers.IO) {
            apiClient.getProducts()
        }

    }
}
