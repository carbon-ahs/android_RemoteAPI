package com.axiagroups.remoteapi.data.local

import androidx.room.Database
import androidx.room.RoomDatabase


/**
 * Created by Ahsan Habib on 5/16/2024.
 * shehanuk.ahsan@gmail.com
 */
@Database(
    entities = [NewsEntity::class, TopNewsEntity::class],
    version = 1
)
abstract class NewsDatabase: RoomDatabase() {
    abstract val dao: NewsDao
}