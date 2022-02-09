
package com.evastos.music.domain.spotify.authentication

import android.arch.lifecycle.MutableLiveData
import com.evastos.music.BuildConfig
import com.evastos.music.data.exception.ExceptionMappers
import com.evastos.music.data.model.authentication.AuthData
import com.evastos.music.data.model.spotify.user.User
import com.evastos.music.data.persistence.prefs.PreferenceStore
import com.evastos.music.data.rx.applySchedulers
import com.evastos.music.data.rx.mapException
import com.evastos.music.data.service.spotify.SpotifyService
import com.evastos.music.data.service.spotify.scopes.Scopes
import com.evastos.music.domain.Repositories
import com.evastos.music.domain.exception.ExceptionMessageProviders
import com.evastos.music.domain.livedata.SingleLiveEvent
import com.evastos.music.inject.qualifier.SpotifyRedirectUri
import com.evastos.music.ui.util.DateTimeUtil
import com.spotify.sdk.android.authentication.AuthenticationRequest
import com.spotify.sdk.android.authentication.AuthenticationResponse
import com.spotify.sdk.android.authentication.AuthenticationResponse.Type
import io.reactivex.disposables.CompositeDisposable
import timber.log.Timber
import javax.inject.Inject

class AuthenticationRepository
@Inject constructor(
    private val spotifyService: SpotifyService,
    private val spotifyScopes: Scopes.Spotify,
    @SpotifyRedirectUri private val spotifyRedirectUri: String,
    private val preferenceStore: PreferenceStore,
    private val dateTimeUtil: DateTimeUtil,
    private val spotifyExceptionMapper: ExceptionMappers.Spotify,
    private val spotifyExceptionMessageProvider: ExceptionMessageProviders.Spotify
) : Repositories.Spotify.Authentication {

    companion object {
        private const val SEC_IN_MILLIS = 1000L
    }

    override val authRequestLiveEvent = SingleLiveEvent<AuthenticationRequest>()
    override val authErrorLiveData = MutableLiveData<String>()
    override val userLiveEvent = SingleLiveEvent<User>()

    override fun authenticateOrGetUser() {
        authErrorLiveData.postValue(null)
        if (isTokenExpired()) {
            authenticate()
        } else {
            userLiveEvent.postValue(preferenceStore.user)
        }
    }