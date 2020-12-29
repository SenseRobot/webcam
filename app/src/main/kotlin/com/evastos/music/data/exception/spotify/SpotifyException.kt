package com.evastos.music.data.exception.spotify

sealed class SpotifyException : Throwable() {

    class ClientException : SpotifyException()

    class ServerExc