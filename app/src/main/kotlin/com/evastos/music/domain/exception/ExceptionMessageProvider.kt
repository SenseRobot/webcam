package com.evastos.music.domain.exception

interface ExceptionMessageProvider<in Exception> {

    fun getMessage(exception: E