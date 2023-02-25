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
import