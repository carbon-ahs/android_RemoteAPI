package com.axiagroups.remoteapi.data

import com.axiagroups.remoteapi.data.local.NewsEntity
import com.axiagroups.remoteapi.data.remote.NewsDto
import com.axiagroups.remoteapi.domain.News


/**
 * Created by Ahsan Habib on 5/16/2024.
 * shehanuk.ahsan@gmail.com
 */

fun NewsDto.toNewsEntity(): NewsEntity {
    return NewsEntity(
        id = id,
        title = title,
        author = author,
        pubTime = time
    )
}

fun NewsEntity.toNews(): News {
    return News(
        id = id,
        title = title,
        author = author,
        pubTime = pubTime
    )
}
