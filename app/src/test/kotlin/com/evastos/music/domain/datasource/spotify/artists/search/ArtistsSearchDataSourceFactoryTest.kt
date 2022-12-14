package com.evastos.music.domain.datasource.spotify.artists.search

import android.arch.core.executor.testing.InstantTaskExecutorRule
import android.arch.lifecycle.Observer
import com.evastos.music.data.network.connectivity.NetworkConnectivityProvider
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import io.reactivex.disposables.CompositeDisposable
import org.junit.Before
import org.junit.Rule
import