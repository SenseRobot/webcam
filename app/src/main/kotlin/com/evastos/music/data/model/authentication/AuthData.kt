package com.evastos.music.data.model.authentication

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AuthData(
    @Json(name = "authToken") val authToken: S