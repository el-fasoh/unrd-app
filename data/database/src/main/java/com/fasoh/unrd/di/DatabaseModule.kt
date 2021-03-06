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

import android.content.Context
import com.fasoh.unrd.UnrdDatabase
import com.fasoh.unrd.daos.CharacterEntityDao
import com.fasoh.unrd.daos.PreviewMediaDao
import com.fasoh.unrd.daos.StoryEntityDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(context: Context): UnrdDatabase = UnrdDatabase.getInstance(context)

    @Provides
    @Singleton
    fun provideStoryDao(database: UnrdDatabase): StoryEntityDao = database.storyDao()

    @Provides
    @Singleton
    fun providePreviewEntity(database: UnrdDatabase): PreviewMediaDao = database.previewDao()

    @Provides
    @Singleton
    fun provideCharacterDao(database: UnrdDatabase): CharacterEntityDao = database.characterDao()
}