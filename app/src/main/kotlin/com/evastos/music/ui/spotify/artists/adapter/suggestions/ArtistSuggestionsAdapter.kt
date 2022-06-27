package com.evastos.music.ui.spotify.artists.adapter.suggestions

import android.app.SearchManager
import android.content.Context
import android.database.MatrixCursor
import android.provider.BaseColumns
import android.support.v4.widget.SimpleCursorAdapter
import com.evastos.music.R
import com.evastos.music.data.model.spotify.item.artist.Artist

/**
 * Shows movie suggestions while typing the query in the search view.
 */
class ArtistSuggestionsAdapter(
    context: Context?
) : SimpleCursorAdapter(
    context,
    R.layout.layout_item_artist_suggestion,
    null,
    Array(1) { SearchManager.SUGGEST_COLUMN_TEXT_1 },
    IntArray(1) { R.id.artistSuggestionTextView },
    0
) {
    private var sug