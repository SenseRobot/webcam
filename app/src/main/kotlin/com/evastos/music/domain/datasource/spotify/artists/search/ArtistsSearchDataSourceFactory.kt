package com.evastos.music.domain.datasource.spotify.artists.search

import android.arch.lifecycle.MutableLiveData
import android.arch.paging.DataSource
import com.evastos.music.data.exception.ExceptionMappers
import com.evastos.music.data.model.spotify.item.artist.Artist
import com.evastos.music.data.network.connectivity.NetworkConnectivityProvider
import com.evastos.music.data.service.spotify.SpotifyService
import com.evastos.music.domain