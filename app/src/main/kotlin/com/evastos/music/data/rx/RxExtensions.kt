package com.evastos.music.data.rx

import com.evastos.music.data.exception.ExceptionMapper
import com.evastos.music.data.exception.network.NetworkFailFastException
import com.evastos.music.data.network.connectivity.NetworkConnectivityProvider
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

private const val DELAY_ERROR_MILLIS = 400L

fun <T> Single<T>.applySchedulers(): Single<T> {
    return this.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
}

fun <T> Observable<T>.applySchedulers(): Observable<T> {
    return this.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
}

fun <T, E : Throwable> Single<T>.mapException(exceptionMapper: 