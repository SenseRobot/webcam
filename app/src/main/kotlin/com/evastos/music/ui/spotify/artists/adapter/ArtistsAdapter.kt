package com.evastos.music.ui.spotify.artists.adapter

import android.arch.paging.PagedListAdapter
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.evastos.music.R
import com.evastos.music.data.model.spotify.item.artist.Artist
import com.evastos.music.inject.module.GlideRequests
import com.evastos.music.ui.util.extensions.debounceClicks
import com.evastos.music.ui.util.extensions.inflate
import com.evasto