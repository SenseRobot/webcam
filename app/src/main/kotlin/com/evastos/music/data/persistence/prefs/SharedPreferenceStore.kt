
package com.evastos.music.data.persistence.prefs

import android.content.Context
import android.content.SharedPreferences
import com.evastos.music.data.model.authentication.AuthData
import com.evastos.music.data.model.spotify.user.User
import com.evastos.music.inject.qualifier.AppContext
import com.squareup.moshi.Moshi

class SharedPreferenceStore(
    @AppContext context: Context
) : PreferenceStore {

    companion object {
        private const val SHARED_PREFERENCES_NAME = "music_preferences"
    }

    private val sharedPreferences =
            context.getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE)

    private val moshi = Moshi.Builder().build()

    override var authData: AuthData?
        get() = sharedPreferences[PreferenceStore.Constants.AUTH_DATA]
        set(value) {
            sharedPreferences[PreferenceStore.Constants.AUTH_DATA] = value
        }