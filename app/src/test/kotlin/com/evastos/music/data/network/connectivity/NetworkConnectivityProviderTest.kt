package com.evastos.music.data.network.connectivity

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.whenever
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class NetworkConnectivityProviderTest {

    private val context = mock<Context>()
    private val connectivityManager = mock<ConnectivityManager>()
    private val netw