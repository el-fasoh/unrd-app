package com.fasohlabs.unrd.network.dispatchers

import okhttp3.mockwebserver.Dispatcher
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.RecordedRequest
import java.net.HttpURLConnection

class ErrorMockDispatcher : Dispatcher() {
    override fun dispatch(request: RecordedRequest): MockResponse =
        MockResponse()
            .setResponseCode(HttpURLConnection.HTTP_UNAUTHORIZED)

}