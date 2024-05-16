package com.axiagroups.remoteapi.data.local

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.axiagroups.remoteapi.domain.News
import com.axiagroups.remoteapi.domain.TopNews


/**
 * Created by Ahsan Habib on 5/16/2024.
 * shehanuk.ahsan@gmail.com
 */
@Dao
interface NewsDao {
    @Upsert
    suspend fun upsertAllNews(news: News)

//    @Query("SELECT * FROM newsentity")
//    fun pagingSource(): PagingSource<Int, NewsEntity>

    @Query("DELETE FROM newsentity")
    fun clearAll()


    // top news
    @Upsert
    suspend fun upsertAllTopNews(topNews: List<TopNewsIdEntity>)

    @Query("SELECT * FROM topnewsidentity")
    fun pagingSource(): PagingSource<Int, TopNewsIdEntity>

    @Query("DELETE FROM topnewsidentity")
    fun clearAllTopNews()

}