package com.evastos.music.data.exception.spotify

import com.evastos.music.data.exception.ExceptionMappers
import com.evastos.music.data.exception.network.NetworkFailFastException
import okhttp3.MediaType
import okhttp3.Protocol
import okhttp3.Request
import okhttp3.ResponseBody
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import retrofit2.HttpException
import retrofit2.Response
import java.net.ConnectException
import java.net.HttpURLConnection
import java.net.SocketTimeoutException
import java.net.UnknownHostException

class SpotifyExceptionMapperTest {

    private lateinit var exceptionMapper: ExceptionMappers.Spotify

    @Before
    fun setUp() {
        exceptionMapper = SpotifyExceptionMapper()
    }

    @Test
    fun map_withSocketTimeoutException_returnsNetworkException() {
        val throwable = SocketTimeoutException()

        val exception = exceptionMapper.map(throwable)

        assertTrue(exception is SpotifyException.NetworkException)
    }

    @Test
    fun map_withUnknownHostException_returnsNetworkException() {
        val throwable = UnknownHostException()

        val exception = exceptionMapper.map(throwable)

        assertTrue(exception is SpotifyException.NetworkException)
    }

    @Test
    fun map_withNetworkFailFastException_returnsNetworkFailFastException() {
        val throwable = NetworkFailFastException()

        val exception = exceptionMapper.map(throwable)

        assertTrue(exception is SpotifyException.NetworkFailFastException)
    }

    @Test
    fun map_withConnectException_returnsServerException() {
        val throwable = ConnectException()

        val exception = exceptionMapper.map(throwable)

        assertTrue(exception is SpotifyException.ServerException)
    }

    @Test
    fun map_withHttpException_with400StatusCode_returnsClientException() {
        val exception = exceptionMapper.map(getHttpException(HttpURLConnection.HTTP_BAD_REQUEST))

        assertTrue(exception is SpotifyException.ClientException)
    }

    @Test
    fun map_withHttpException_with415StatusCode_returnsClientException() {
        val exception =
                exceptionMapper.map(getHttpException(HttpURLConnection.HTTP_UNSUPPORTED_TYPE))

        assertTrue(exception is SpotifyException.ClientException)
    }

    @Test
    fun map_withHttpException_with500StatusCode_returnsServerException() {
        val exception = exceptionMapper.map(getHttpException(HttpURLConnection.HTTP_INTERNAL_ERROR))

        assertTrue(exception is SpotifyException.ServerException)
    }

    @Test
    fun map_withHttpException_with505StatusCode_returnsServerException() {
        val exception = exceptionMapper.map(getHttpException(HttpURLConnection.HTTP_VERSION))

        assertTrue(exception is SpotifyException.Serve