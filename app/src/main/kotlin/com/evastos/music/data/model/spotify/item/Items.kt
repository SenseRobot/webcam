package com.evastos.music.data.model.spotify.item

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Items<T>(
    @Json(name =