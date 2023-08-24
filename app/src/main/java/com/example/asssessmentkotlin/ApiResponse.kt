package com.example.asssessmentkotlin

import retrofit2.http.GET

interface ApiResponse {
    @GET("/posts")
    suspend fun getPosts(): List<Post>
}
