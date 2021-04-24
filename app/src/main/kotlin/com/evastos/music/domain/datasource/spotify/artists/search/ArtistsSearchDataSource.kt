package com.evastos.music.domain.datasource.spotify.artists.search

import android.arch.lifecycle.MutableLiveData
import android.arch.paging.PageKeyedDataSource
import com.evastos.music.data.exception.ExceptionMappers
import com.evastos.music.data.model.spotify.item.ItemType
import com.evastos.music.data.model.spotify.item.ItemTypes
import com.evastos.music.data.model.spotify.item.artist.Artist
import com.evastos.music.data.model.spotify.search.SearchResponse
import com.evastos.music.data.network.connectivity.NetworkConnectivityProvider
import com.evastos.music.data.rx.applySchedulers
import com.evastos.music.data.r