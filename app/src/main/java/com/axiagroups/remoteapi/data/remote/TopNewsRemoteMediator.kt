package com.axiagroups.remoteapi.data.remote

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.axiagroups.remoteapi.data.local.NewsDatabase
import com.axiagroups.remoteapi.data.local.NewsEntity
import com.axiagroups.remoteapi.data.local.TopNewsEntity
import com.axiagroups.remoteapi.data.local.TopNewsIdEntity
import com.axiagroups.remoteapi.data.mappers.toTopNewsIdEntity
import okio.IOException
import retrofit2.HttpException


/**
 * Created by Ahsan Habib on 5/16/2024.
 * shehanuk.ahsan@gmail.com
 */

@OptIn(ExperimentalPagingApi::class)
class TopNewsRemoteMediator(
    private val newsDb: NewsDatabase,
    private val newsApi: NewsApi
) : RemoteMediator<Int, TopNewsIdEntity>() {
    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, TopNewsIdEntity>
    ): MediatorResult {
        return try {
            val loadKey = when(loadType) {
                LoadType.REFRESH -> 1
                LoadType.PREPEND -> return MediatorResult.Success(
                    endOfPaginationReached = true
                )
                LoadType.APPEND -> {
                    val lastItem = state.lastItemOrNull()
                    if(lastItem == null) {
                        1
                    } else {
                        (lastItem.id / state.config.pageSize) + 1
                    }
                }
            }

            val topNewsIds = newsApi.getTopNewsId()

            newsDb.withTransaction {
                if(loadType == LoadType.REFRESH) {
                    newsDb.dao.clearAllTopNews()
                }
                val topNewsIdEntities = topNewsIds.map {
                    it.toTopNewsIdEntity()
                }
                newsDb.dao.upsertAllTopNews(topNewsIdEntities)
            }

            MediatorResult.Success(
                endOfPaginationReached = topNewsIds.isEmpty()
            )
        } catch (e: IOException) {
            MediatorResult.Error(e)
        }catch (e: HttpException) {
            MediatorResult.Error(e)
        }
    }

}
