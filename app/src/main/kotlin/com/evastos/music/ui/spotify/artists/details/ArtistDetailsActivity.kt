
package com.evastos.music.ui.spotify.artists.details

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.MenuItem
import com.evastos.music.R
import com.evastos.music.data.model.spotify.item.artist.Artist
import com.evastos.music.inject.module.GlideApp
import com.evastos.music.ui.base.BaseActivity
import com.evastos.music.ui.util.extensions.loadImage