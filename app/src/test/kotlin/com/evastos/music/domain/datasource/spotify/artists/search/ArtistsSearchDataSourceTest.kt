package com.evastos.music.domain.datasource.spotify.artists.search

import android.arch.core.executor.testing.InstantTaskExecutorRule
import android.arch.lifecycle.Observer
import android.arch.paging.PageKeyedDataSource
import com.evastos.music.RxImmediateSchedulerRule
import com.evastos.music.TestUtil
import com.evastos.music.data.exception.ExceptionMappers
import com.evastos.music.data.exception.spotify.SpotifyException
import com.evastos.music.data.model.spotify.item.artist.Artist
import com.evastos.music.data.network.connectivity.NetworkConnectivityProvider
import com.evastos.music.data.service.spotify.SpotifyService
import com.evastos.music.domain.exception.ExceptionMessageProviders
import com.evastos.music.domain.livedata.LoadingState
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.check
import co