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
imp