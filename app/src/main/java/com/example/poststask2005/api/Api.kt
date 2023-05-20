package com.example.poststask2005.api

import com.example.poststask2005.model.Posts
import retrofit2.Call
import retrofit2.http.GET

interface Api{

    @GET("posts")
    fun getPosts() : Call<List<Posts>>

}