package com.evastos.music.inject.viewmodel

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton

@Singleton
open class ViewModelFactory
@Inject constructor(
    private val creators: Ma