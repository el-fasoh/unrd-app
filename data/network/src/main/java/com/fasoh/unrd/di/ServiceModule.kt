package com.fasoh.unrd.di

import com.fasoh.unrd.api.UnrdApi
import com.fasoh.unrd.services.UnrdServiceImpl
import com.fasohlabs.unrd.domain.sercives.UnrdService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {

    @Provides
    @Singleton
    fun provideUnrdService(api: UnrdApi): UnrdService = UnrdServiceImpl(api)
}