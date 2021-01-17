package com.evastos.music.data.model.spotify.item

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Items<T>(
    @Json(name = "href") val href: String?,
    @Json(name = "items") val items: List<T>?,
    @Json(name = "limit") val limit: Int?,
  