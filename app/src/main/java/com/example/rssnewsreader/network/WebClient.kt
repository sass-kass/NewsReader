package com.example.rssnewsreader.network

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.simplexml.SimpleXmlConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

private const val BASE_URL = "https://rss.nytimes.com/services/xml/rss/nyt/"

@Module
@InstallIn(SingletonComponent::class)
object WebClient {
    private var retrofit: Retrofit? = null

    @Provides
    @Singleton
    fun getClient(): NewsService {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .client(
                    OkHttpClient.Builder().connectTimeout(
                        60,
                        TimeUnit.SECONDS
                    ).addInterceptor(HttpLoggingInterceptor().apply {
                        level = HttpLoggingInterceptor.Level.BASIC
                    }).build()
                )
                .build()
        }
        return retrofit!!.create(NewsService::class.java)
    }
}