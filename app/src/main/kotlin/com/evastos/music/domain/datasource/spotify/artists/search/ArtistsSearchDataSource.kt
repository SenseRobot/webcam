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
import com.evastos.music.data.rx.checkNetwork
import com.evastos.music.data.rx.delayError
import com.evastos.music.data.rx.mapException
import com.evastos.music.data.service.spotify.SpotifyService
import com.evastos.music.domain.exception.ExceptionMessageProviders
import com.evastos.music.domain.livedata.LoadingState
import com.evastos.music.ui.util.extensions.formatQuery
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable

class ArtistsSearchDataSource(
    private val query: String,
    private val spotifyService: SpotifyService,
    private val exceptionMapper: ExceptionMappers.Spotify,
    private val exceptionMessageProvider: ExceptionMessageProviders.Spotify,
    private val networkConnectivityProvider: NetworkConnectivityProvider,
    private val disposables: CompositeDispos