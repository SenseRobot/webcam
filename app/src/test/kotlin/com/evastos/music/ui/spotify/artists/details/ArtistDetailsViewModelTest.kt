package com.evastos.music.ui.spotify.artists.details

import android.arch.core.executor.testing.InstantTaskExecutorRule
import android.arch.lifecycle.Observer
import com.evastos.music.RxImmediateSchedulerRule
import com.evastos.music.TestUtil
import com.jakewharton.rxrelay2.PublishRelay
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ArtistDetailsViewModelTest {

    @Rule
    @JvmField
    var testSchedulerRule = RxImmediateSchedulerRule()

    @Rule
    @JvmField
    val rule = InstantTaskExecutorRule()

    private val artistImageObserver = mock<Observer<String>>()
    private val artistNameObserver = mock<Observer<String>>()
    private val artistGenresObserver = mock<Observer<String>>()
    private val artistFollowersObserver = mock<Observer<Int>>()
    private val artistExternalUrlObserver = mock<Observer<St