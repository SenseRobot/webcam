package com.evastos.music.data.model.spotify.item

import com.squareup.moshi.Json
import java.util.Locale

/**
 * Spotify search item types.
 */
enum class ItemType {
    @Json(name = "album")
    ALBUM,
    @Json(name = "artist"