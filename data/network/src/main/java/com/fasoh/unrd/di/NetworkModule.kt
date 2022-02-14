package com.fasoh.unrd.di

import com.fasoh.unrd.api.UnrdApi
import com.fasohlabs.unrd.network.BuildConfig
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    internal fun provideOkhttpClientToken(): OkHttpClient {
        val httpClient = OkHttpClient.Builder()
        httpClient.connectTimeout(BuildConfig.HOST_CONNECT_TIMEOUT, TimeUnit.SECONDS)
        httpClient.readTimeout(BuildConfig.HOST_READ_TIMEOUT, TimeUnit.SECONDS)
        if (BuildConfig.DEBUG) {
            httpClient.addInterceptor(getLoggingInterceptor())
        }
        return httpClient.build()
    }

    @Singleton
    @Provides
    internal fun provideUnrdApi(retrofit: Retrofit): UnrdApi =
        retrofit.create(UnrdApi::class.java)

    @Singleton
    @Provides
    internal fun provideRetrofit(
        okHttpClient: OkHttpClient
    ) = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
        .baseUrl(BuildConfig.BASE_URL)
        .client(okHttpClient)
        .build()

    private fun getLoggingInterceptor(): HttpLoggingInterceptor {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        return logging
    }
}