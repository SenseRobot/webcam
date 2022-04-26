package com.evastos.music.ui.spotify.artists

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MediatorLiveData
import android.arch.paging.PagedList
import com.evastos.music.data.model.spotify.item.artist.Artist
import com.evastos.music.domain.Repositories
import com.evastos.music.domain.livedata.Listing
import com.evastos.music.domain.livedata.LoadingState
import com.evastos.music.domain.livedata.SingleLiveEvent
import com.evastos.music.ui.base.BaseViewModel
import io.reactivex.Observable
import javax.inject.Inject

class ArtistsViewModel
@Inject constructor(
    private val repository: Repositories.Spotify.Artists
) : BaseViewModel() {

    // ARTISTS
    val artistsLiveData = MediatorLiveData<Pa