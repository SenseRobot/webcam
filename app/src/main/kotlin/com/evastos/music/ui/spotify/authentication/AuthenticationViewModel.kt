package com.evastos.music.ui.spotify.authentication

import com.evastos.music.domain.Repositories
import com.evastos.music.ui.base.BaseViewModel
import com.spotify.sdk.android.authentication.AuthenticationResponse
import io.reactivex.Observable
import javax.inject.Inject

class AuthenticationViewModel
@Inject constructor(
    private val repository: Repositories.Spotify.Authentication
) : BaseViewModel() {

    val authRequestLiveEvent = repository.authRequestLiveEvent
    val authErrorLiveData = repository.authErrorLiveData
    val userLiveEvent = repository.userLiveEvent

    fun onCreate(netw