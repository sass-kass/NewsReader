package com.example.rssnewsreader.repository

import com.example.rssnewsreader.network.Feed
import com.example.rssnewsreader.network.WebClient
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NewsRepository @Inject constructor() {
    fun getNews(): Feed? {
        val news: Feed?
        val response = WebClient.getClient().getItems().execute()
        news = response.body()
        return news
    }
}