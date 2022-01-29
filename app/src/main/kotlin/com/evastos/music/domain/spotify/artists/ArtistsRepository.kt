
package com.evastos.music.domain.spotify.artists

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Transformations
import android.arch.paging.LivePagedListBuilder
import android.support.annotation.MainThread
import com.evastos.music.data.exception.ExceptionMappers
import com.evastos.music.data.model.spotify.item.ItemType
import com.evastos.music.data.model.spotify.item.ItemTypes
import com.evastos.music.data.model.spotify.item.artist.Artist
import com.evastos.music.data.network.connectivity.NetworkConnectivityProvider
import com.evastos.music.data.persistence.prefs.PreferenceStore
import com.evastos.music.data.rx.applySchedulers
import com.evastos.music.data.rx.checkNetwork
import com.evastos.music.data.rx.mapException
import com.evastos.music.data.service.spotify.SpotifyService
import com.evastos.music.domain.Repositories
import com.evastos.music.domain.datasource.spotify.artists.search.ArtistsSearchDataSourceFactory