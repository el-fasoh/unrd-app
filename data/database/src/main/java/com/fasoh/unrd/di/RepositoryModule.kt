/*
 * Copyright 2022 Unrd
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.fasoh.unrd.di

import com.fasoh.unrd.ConnectionManager
import com.fasoh.unrd.daos.CharacterEntityDao
import com.fasoh.unrd.daos.PreviewMediaDao
import com.fasoh.unrd.daos.StoryEntityDao
import com.fasoh.unrd.repository.StoryRepositoryImpl
import com.fasohlabs.unrd.domain.repositories.StoryRepository
import com.fasohlabs.unrd.domain.sercives.UnrdService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal class RepositoryModule {

    @Provides
    @Singleton
    fun provideStoryRepository(
        storyEntityDao: StoryEntityDao,
        previewMediaDao: PreviewMediaDao,
        characterEntityDao: CharacterEntityDao,
        service: UnrdService,
        connectionManager: ConnectionManager
    ): StoryRepository =
        StoryRepositoryImpl(
            storyEntityDao = storyEntityDao,
            previewMediaDao = previewMediaDao,
            characterEntityDao = characterEntityDao,
            service = service,
            connectionManager = connectionManager
        )
}