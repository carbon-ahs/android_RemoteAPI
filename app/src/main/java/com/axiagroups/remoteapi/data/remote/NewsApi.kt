package com.axiagroups.remoteapi.data.remote

import retrofit2.http.GET
import retrofit2.http.Query


/**
 * Created by Ahsan Habib on 5/16/2024.
 * shehanuk.ahsan@gmail.com
 */
interface NewsApi {
    @GET("item/{id}.json")
    suspend fun getNews(
        @Query("id") id: Int,
    )

    @GET("topstories.json")
    suspend fun getTopNewsId() : List<TopNewsDto>
    companion object {
        const val BASE_URL = "https://hacker-news.firebaseio.com/v0/"
    }
}