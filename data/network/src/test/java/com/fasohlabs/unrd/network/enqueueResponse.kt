package com.fasohlabs.unrd.network

import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okio.buffer
import okio.source
import java.io.InputStream
import java.nio.charset.StandardCharsets

internal fun MockWebServer.enqueueResponse(fileName: String? = null, code: Int) {
    fileName?.let {
        val inputStream: InputStream? = javaClass.classLoader?.getResourceAsStream(it)

        val source = inputStream?.let { inputStream.source().buffer() }
        source?.let {
            enqueue(
                MockResponse()
                    .setResponseCode(code)
                    .setBody(source.readString(StandardCharsets.UTF_8))
            )
        }
    } ?: run {
        enqueue(MockResponse().setResponseCode(code))
    }
}