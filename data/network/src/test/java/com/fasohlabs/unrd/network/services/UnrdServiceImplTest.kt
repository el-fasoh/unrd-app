package com.fasohlabs.unrd.network.services

import com.fasoh.unrd.api.UnrdApi
import com.fasoh.unrd.services.UnrdServiceImpl
import com.fasohlabs.unrd.domain.sercives.UnrdService
import com.fasohlabs.unrd.domain.utils.UnrdRequest
import com.fasohlabs.unrd.network.enqueueResponse
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.HttpURLConnection

internal class UnrdServiceImplTest {

    private val mockWebServer = MockWebServer()

    private val retrofit = Retrofit.Builder()
        .baseUrl(mockWebServer.url("/"))
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    private val api = retrofit.create(UnrdApi::class.java)
    private val service: UnrdService by lazy {
        UnrdServiceImpl(api)
    }

    @Test
    fun `test fetch stories success`() = runBlocking {
        mockWebServer.enqueueResponse("sample_story.json", HttpURLConnection.HTTP_OK)

        val result = service.fetchStories()
        assert(result is UnrdRequest.Success)
    }

    @Test
    fun `test fetch stories fail`() = runBlocking {
        mockWebServer.enqueueResponse(code = HttpURLConnection.HTTP_UNAUTHORIZED)

        val result = service.fetchStories()
        assert(result is UnrdRequest.Error)
    }

    @After
    fun tearDown() {
        mockWebServer.shutdown()
    }
}