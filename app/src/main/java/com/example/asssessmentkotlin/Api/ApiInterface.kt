package com.example.asssessmentkotlin.Api

import com.example.asssessmentkotlin.Model.Post
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {
    @GET("/posts")
    suspend   fun getProducts():Response<List<Post>>


}