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

private cons