package com.evastos.music.ui.spotify.artists

import android.arch.core.executor.testing.InstantTaskExecutorRule
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import android.arch.paging.PagedList
import com.evastos.music.RxImmediateSchedulerRule
import com.evastos.music.TestUtil
import com.evastos.music.data.model.spotify.item.artist.Artist
import com.evastos.music.domain.Repositories
import com.evastos.music.domain.livedata.LoadingState
import com.jakewharton.rxrelay2.PublishRelay
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.check
import com.nhaarman.mockito_kotlin.eq
import com.nhaarman.mockito_kotlin.isNull
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.never
import com.nhaarman.mockito_kotlin.reset
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ArtistsViewModelTest {

    @Rule
    @JvmField
    var testSchedulerRule = RxImmediateSchedulerRule()

    @Rule
    @JvmField
    val rule = InstantTaskExecutorRule()

    private val repository = mock<Repositories.Spotify.Artists>()

    private val artistsLiveDataObserver = mock<Observer<PagedList<Artist>>>()
    private val loadingStateLiveDataObserver = mock<Observer<LoadingState>>()
    private val artistSuggestionsLiveDataObserver = mock<Observer<List<Artist>>>()
    private val artistDetailsLiveDataObserver = mock<Observer<Artist>>()
    private val artistSearchLiveDataObserver = mock<Observer<String>>()
    private val networkConnectivityBannerObserver = mock<Observer<Boolean>>()

    private val networkConnectivityRelay = PublishRelay.create<Boolean>()
    private val artistSearchLiveData = MutableLiveData<String>()

    private lateinit var viewModel: ArtistsViewModel

    @Before
    fun setUp() {
        whenever(repository.searchArtists(isNull(), any()))
                .thenReturn(TestUtil.artistsListing1)
        whenever(repository.searchArtists(eq("Interpol"), any()))
                .thenReturn(TestUtil.artistsListing2)
        whenever(repository.searchArtists(eq("No Rome"), any()))
                .thenReturn(TestUtil.artistsListing3)

        whenever(repository.getArtistSuggestions(eq("Not"), any()))
                .thenReturn(TestUtil.artistSuggestions1)
        whenever(repository.getArtistSuggestions(eq("Nothing"), any()))
                .thenReturn(TestUtil.artistSuggestions2)

        whenever(repository.artistSearchLiveData).thenReturn(artistSearchLiveData)

        viewModel = ArtistsViewModel(repository)
        viewModel.artistsLiveData