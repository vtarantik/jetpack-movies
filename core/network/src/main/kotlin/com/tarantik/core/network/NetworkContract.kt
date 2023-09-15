package com.tarantik.core.network

interface NetworkContract {
    fun onNetworkParseError(path: String, method: String, reason: String)
}