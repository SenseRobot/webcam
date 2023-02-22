package com.evastos.music.ui.base

import android.arch.core.executor.testing.InstantTaskExecutorRule
import com.evastos.music.RxImmediateSchedulerRule
import com.jakewharton.rxrelay2.PublishRelay
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.times
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.verifyNoMoreInteractions
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class BaseViewModelTest {

    @Rule
    @JvmField
    var testSchedulerRule = RxImmediateSchedulerRule()

    @Rule
    @JvmField
    val rule = InstantTaskExecutorRule()

    private val networkConnectivityRelay = PublishRelay.create<Boolean>()
    private val connectivityAction = mock<(Boolean) -> Unit>()

    private lateinit var viewModel: TestViewModel

    @Before
    fun setUp() {
        viewModel = TestViewModel()
    }

    @Test
    fun getNetworkConnectivityLiveData_withNetworkConnectivityEvents_invokesDistinctValues() {
        viewModel.onCreate(networkConnectivityRelay, connectivityAction)

        networkConnectivityRelay.accept(true)
        networkConnectivityRelay.accept(true)
        networkConnectivityRelay.accept(false)
        networkConnectivityRelay.accept(true)
        networkConnectivityRelay.accept(false)
        networkConnectivityRelay.accept(false)

     