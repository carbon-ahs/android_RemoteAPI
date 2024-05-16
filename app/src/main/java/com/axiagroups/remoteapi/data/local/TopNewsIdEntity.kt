package com.axiagroups.remoteapi.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey


/**
 * Created by Ahsan Habib on 5/16/2024.
 * shehanuk.ahsan@gmail.com
 */
@Entity
data class TopNewsIdEntity(
    @PrimaryKey
    val id: Int
)