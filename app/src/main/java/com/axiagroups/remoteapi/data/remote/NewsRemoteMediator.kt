//package com.axiagroups.remoteapi.data.remote
//
//import androidx.paging.ExperimentalPagingApi
//import androidx.paging.LoadType
//import androidx.paging.PagingState
//import androidx.paging.RemoteMediator
//import androidx.room.withTransaction
//import com.axiagroups.remoteapi.data.local.NewsDatabase
//import com.axiagroups.remoteapi.data.local.NewsEntity
//import okio.IOException
//import retrofit2.HttpException
//
//
///**
// * Created by Ahsan Habib on 5/16/2024.
// * shehanuk.ahsan@gmail.com
// */
//@OptIn(ExperimentalPagingApi::class)
//class NewsRemoteMediator(
//    private val newsDb: NewsDatabase,
//    private val newsApi: NewsApi
//) : RemoteMediator<Int, NewsEntity>(){
//    override suspend fun load(
//        loadType: LoadType,
//        state: PagingState<Int, NewsEntity>
//    ): MediatorResult {
//        return try {
//            val loadKey = when(loadType) {
//                LoadType.REFRESH -> 1
//                LoadType.PREPEND -> return MediatorResult.Success(
//                    endOfPaginationReached = true
//                )
//                LoadType.APPEND -> {
//                    val lastItem = state.lastItemOrNull()
//                    if (lastItem == null) {
//                        1
//                    } else {
//                        (lastItem.id / state.config.pageSize) + 1 // FIXME: Potencial pitfall
//                    }
//                }
//            }
//            val allNews = newsApi.getNews(
//                id =
//            )
//
//            newsDb.withTransaction {
//
//            }
//        } catch (e: IOException) {
//            MediatorResult.Error(e)
//        }catch (e: HttpException) {
//            MediatorResult.Error(e)
//        }
//    }
//}