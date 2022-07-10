package com.evastos.music.ui.util.extensions

import android.graphics.drawable.Drawable
import android.net.Uri
import android.widget.ImageView
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.evastos.music.R
import com.evastos.music.inject.module.GlideRequests

fun GlideRequests.load