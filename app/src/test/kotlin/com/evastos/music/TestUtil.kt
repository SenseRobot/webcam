
package com.evastos.music

import android.arch.lifecycle.MutableLiveData
import android.arch.paging.PagedList
import com.evastos.music.data.model.authentication.AuthData
import com.evastos.music.data.model.spotify.item.ItemType
import com.evastos.music.data.model.spotify.item.Items
import com.evastos.music.data.model.spotify.item.artist.Artist
import com.evastos.music.data.model.spotify.item.artist.Followers
import com.evastos.music.data.model.spotify.item.artist.Image
import com.evastos.music.data.model.spotify.search.ExternalUrls
import com.evastos.music.data.model.spotify.search.SearchResponse
import com.evastos.music.data.model.spotify.user.User
import com.evastos.music.domain.livedata.Listing
import com.evastos.music.domain.livedata.LoadingState
import com.nhaarman.mockito_kotlin.mock
import com.spotify.sdk.android.authentication.AuthenticationResponse

object TestUtil {

    val artistPagedList1 = mock<PagedList<Artist>>()
    val artists1 = MutableLiveData<PagedList<Artist>>()
    val artistsLoadingState1 = MutableLiveData<LoadingState>()
    val artistsRefresh1 = mock<() -> Unit>()
    val artistsRetry1 = mock<() -> Unit>()

    val artistsListing1 = Listing(
        pagedList = artists1,
        loadingState = artistsLoadingState1,
        refresh = artistsRefresh1,
        retry = artistsRetry1)

    val artistPagedList2 = mock<PagedList<Artist>>()
    val artists2 = MutableLiveData<PagedList<Artist>>()
    val artistsLoadingState2 = MutableLiveData<LoadingState>()
    val artistsRefresh2 = mock<() -> Unit>()
    val artistsRetry2 = mock<() -> Unit>()

    val artistsListing2 = Listing(
        pagedList = artists2,
        loadingState = artistsLoadingState2,
        refresh = artistsRefresh2,
        retry = artistsRetry2)

    val artistPagedList3 = mock<PagedList<Artist>>()
    val artists3 = MutableLiveData<PagedList<Artist>>()
    val artistsLoadingState3 = MutableLiveData<LoadingState>()
    val artistsRefresh3 = mock<() -> Unit>()
    val artistsRetry3 = mock<() -> Unit>()

    val artistsListing3 = Listing(
        pagedList = artists3,
        loadingState = artistsLoadingState3,
        refresh = artistsRefresh3,
        retry = artistsRetry3)

    val artistSuggestions1 = MutableLiveData<List<Artist>>()
    val artistSuggestions2 = MutableLiveData<List<Artist>>()

    val artist = Artist(
        id = "",
        type = ItemType.ARTIST,
        popularity = 8,
        externalUrls = ExternalUrls("external_url_spotify"),
        followers = Followers(82773),
        genres = listOf("indie", "dreampop", "shoegaze"),
        href = "artist_href",
        images = listOf(Image(width = 13, height = 21, url = "image_url"),
            Image(width = 4, height = 40, url = "image_url2")),
        name = "Iceage",
        uri = "artist_uri"
    )

    val artistList1 = listOf(artist)
    val artistList2 = listOf(artist, artist)

    val loading = LoadingState.Loading()
    val success = LoadingState.Success()
    val error = LoadingState.Error("error_message")

    val authResponse = AuthenticationResponse.Builder().build()

    val searchResponse = SearchResponse(
        albums = null,
        tracks = null,
        playlists = null,
        artists = Items(
            href = "href",
            items = artistList2,
            offset = 0,
            limit = 10,
            total = 50
        )
    )

    val autDataValid = AuthData(
        authToken = "authTokenValid",
        authTokenExpiresIn = 1000L,
        authTokenRefreshedAt = 0L
    )

    val autDataExpired = AuthData(
        authToken = "authTokenExpired",
        authTokenExpiresIn = 0L,
        authTokenRefreshedAt = 10L
    )

    val user = User(
        id = "id",
        displayName = "displayName",
        uri = "uri",
        type = "user",
        email = "email"
    )
}