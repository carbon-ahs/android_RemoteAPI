package com.axiagroups.remoteapi.data.mappers

import com.axiagroups.remoteapi.data.local.TopNewsIdEntity
import com.axiagroups.remoteapi.data.remote.TopNewsDto
import com.axiagroups.remoteapi.domain.TopNews


/**
 * Created by Ahsan Habib on 5/16/2024.
 * shehanuk.ahsan@gmail.com
 */

fun TopNewsDto.toTopNewsIdEntity() : TopNewsIdEntity {
    return TopNewsIdEntity(
        id = id
    )
}

fun TopNewsIdEntity.toTopNews(): TopNews {
    return TopNews(
        id = id
    )
}