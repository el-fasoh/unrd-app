package com.fasohlabs.unrd.network.services

import com.fasoh.unrd.api.UnrdApi
import com.fasoh.unrd.services.UnrdServiceImpl
import com.fasohlabs.unrd.domain.sercives.UnrdService
import com.fasohlabs.unrd.domain.utils.UnrdRequest
import com.fasohlabs.unrd.network.dispatchers.ErrorMockDispatcher
import com.fasohlabs.unrd.network.dispatchers.MockRequestDispatcher
import com.google.common.truth.Truth
import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

internal class UnrdServiceImplTest {

    private lateinit var mockWebServer: MockWebServer
    private lateinit var service: UnrdService
    private lateinit var okHttpClient: OkHttpClient
    private lateinit var loggingInterceptor: HttpLoggingInterceptor

    @Before
    fun setUp() {
        mockWebServer = MockWebServer()
        mockWebServer.dispatcher = MockRequestDispatcher()
        mockWebServer.start()

        loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        okHttpClient = buildOkhttpClient(loggingInterceptor)

        val retrofit = Retrofit.Builder()
            .baseUrl(mockWebServer.url("/"))
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val api = retrofit.create(UnrdApi::class.java)
        service = UnrdServiceImpl(api)
    }

    private fun buildOkhttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .build()
    }

    @Test
    fun `test fetch stories success`() = runBlocking {
        val result = service.fetchStories()
        Truth.assertThat(result).isNotNull()
    }

    @Test
    fun `test fetch stories fail`() = runBlocking {
        mockWebServer.dispatcher = ErrorMockDispatcher()
        val result = service.fetchStories()
        assert(result is UnrdRequest.Error)
    }

    @After
    fun tearDown() {
        mockWebServer.shutdown()
    }
}