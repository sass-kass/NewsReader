package com.example.rssnewsreader.network

import retrofit2.Call
import retrofit2.http.GET

interface NewsService {
    @GET("World.xml")
    fun getItems(): Call<Feed>
}