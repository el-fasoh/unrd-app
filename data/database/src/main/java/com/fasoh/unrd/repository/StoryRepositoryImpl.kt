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
package com.fasoh.unrd.repository

import com.fasoh.unrd.ConnectionManager
import com.fasoh.unrd.daos.CharacterEntityDao
import com.fasoh.unrd.daos.PreviewMediaDao
import com.fasoh.unrd.daos.StoryEntityDao
import com.fasoh.unrd.entities.mappers.toDomain
import com.fasoh.unrd.entities.mappers.toEntity
import com.fasohlabs.unrd.core.isEmpty
import com.fasohlabs.unrd.core.zeroIfNull
import com.fasohlabs.unrd.domain.exceptions.ApiException
import com.fasohlabs.unrd.domain.exceptions.ConnectionException
import com.fasohlabs.unrd.domain.models.ApiResponseData
import com.fasohlabs.unrd.domain.models.PreviewMedia
import com.fasohlabs.unrd.domain.repositories.StoryRepository
import com.fasohlabs.unrd.domain.sercives.UnrdService
import com.fasohlabs.unrd.domain.utils.UnrdRequest
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

internal class StoryRepositoryImpl @Inject constructor(
    private val storyEntityDao: StoryEntityDao,
    private val previewMediaDao: PreviewMediaDao,
    private val characterEntityDao: CharacterEntityDao,
    private val service: UnrdService,
    private val connectionManager: ConnectionManager
) : StoryRepository {
    override fun getStory() = flow {
        if (connectionManager.isNetworkAvailable()) {
            when (val result: UnrdRequest<ApiResponseData> = service.fetchStories()) {
                is UnrdRequest.Error -> emit(UnrdRequest.Error(ApiException()))
                is UnrdRequest.Success -> {
                    emit(UnrdRequest.Loading)
                    result.data.result?.let { story ->
                        storyEntityDao.save(story.toEntity())
                        previewMediaDao.save(
                            story.previewMedia.orEmpty()
                                .map {
                                    it.toEntity(storyId = story.storyId.zeroIfNull())
                                }
                        )
                        characterEntityDao.save(
                            story.characters.orEmpty()
                                .map {
                                    it.toEntity(storyId = story.storyId.zeroIfNull())
                                }
                        )
                    }
                    storyEntityDao.fetchStories().collect { stories ->
                        emit(UnrdRequest.Success(stories.map { it.toDomain() }.first()))
                    }
                }
                else -> Unit
            }
        } else {
            if (storyEntityDao.countStories().isEmpty()) {
                emit(UnrdRequest.Error(ConnectionException()))
                return@flow
            } else {
                storyEntityDao.fetchStories().collect { stories ->
                    emit(UnrdRequest.Success(stories.map { it.toDomain() }.first()))
                }
            }
        }
    }

    override fun fetchMedia(storyId: Long): Flow<List<PreviewMedia>> =
        previewMediaDao.fetchPreviewMediaByStoryId(storyId).map { mediaItems ->
            mediaItems.map { it.toDomain() }
        }
}