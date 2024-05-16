package com.axiagroups.remoteapi.presentation

import androidx.lifecycle.ViewModel
import androidx.paging.Pager
import androidx.paging.map
import androidx.viewpager.widget.ViewPager
import com.axiagroups.remoteapi.data.local.TopNewsIdEntity
import com.axiagroups.remoteapi.data.mappers.toTopNews
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import javax.inject.Inject


/**
 * Created by Ahsan Habib on 5/16/2024.
 * shehanuk.ahsan@gmail.com
 */
@HiltViewModel
class TopNewsViewModel @Inject constructor(
    pager: Pager<Int, TopNewsIdEntity>
) : ViewModel() {
    val topNewsPagingFlow = pager
        .flow
        .map { pagingData ->
            pagingData.map { it.toTopNews() }
        }
}