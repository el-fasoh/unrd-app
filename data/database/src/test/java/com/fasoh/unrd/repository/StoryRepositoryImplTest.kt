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

import android.os.Build
import androidx.test.ext.junit.runners.AndroidJUnit4
import app.cash.turbine.test
import com.fasoh.unrd.AppDatabaseTest
import com.fasoh.unrd.ConnectionManager
import com.fasoh.unrd.entities.mappers.toEntity
import com.fasohlabs.unrd.core.isEmpty
import com.fasohlabs.unrd.core.zeroIfNull
import com.fasohlabs.unrd.domain.exceptions.ApiException
import com.fasohlabs.unrd.domain.models.ApiResponseData
import com.fasohlabs.unrd.domain.models.Character
import com.fasohlabs.unrd.domain.models.Image
import com.fasohlabs.unrd.domain.models.PreviewMedia
import com.fasohlabs.unrd.domain.models.Status
import com.fasohlabs.unrd.domain.models.Story
import com.fasohlabs.unrd.domain.repositories.StoryRepository
import com.fasohlabs.unrd.domain.sercives.UnrdService
import com.fasohlabs.unrd.domain.utils.UnrdRequest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever
import org.robolectric.annotation.Config
import kotlin.time.ExperimentalTime

@ExperimentalTime
@ExperimentalCoroutinesApi
@Config(maxSdk = Build.VERSION_CODES.P, minSdk = Build.VERSION_CODES.P)
@RunWith(AndroidJUnit4::class)
internal class StoryRepositoryImplTest : AppDatabaseTest() {
    private val service: UnrdService = mock()
    private val connectionManager: ConnectionManager = mock()
    private val repository: StoryRepository by lazy {
        StoryRepositoryImpl(
            database.storyDao(),
            database.previewDao(),
            database.characterDao(),
            service,
            connectionManager
        )
    }

    @Before
    fun setUp() {
        super.setup()
    }

    @Test
    fun `test getStory success`() = runBlocking {
        whenever(connectionManager.isNetworkAvailable()).thenReturn(true)
        whenever(service.fetchStories()).thenReturn(
            UnrdRequest.Success(
                ApiResponseData(
                    result = story,
                    status = Status()
                )
            )
        )
        repository.getStory().test {
            assert(awaitItem() is UnrdRequest.Loading)
            assert(awaitItem() is UnrdRequest.Success)
        }
        assert(!database.storyDao().countStories().isEmpty())
        assert(!database.characterDao().countCharacters().isEmpty())
        assert(!database.previewDao().countMedia().isEmpty())
    }

    @Test
    fun `test getStory fail connection exception`() = runBlocking {
        whenever(connectionManager.isNetworkAvailable()).thenReturn(false)
        repository.getStory().test {
            val item = awaitItem()
            assert(item is UnrdRequest.Error && item.isConnectionException)
            awaitComplete()
        }
    }

    @Test
    fun `test getStory fail api exception`() = runBlocking {
        whenever(connectionManager.isNetworkAvailable()).thenReturn(true)
        whenever(service.fetchStories()).thenReturn(UnrdRequest.error(ApiException()))
        repository.getStory().test {
            val item = awaitItem()
            assert(item is UnrdRequest.Error && item.isApiException)
            awaitComplete()
        }
    }

    @Test
    fun `test getStory offline success`() = runBlocking {
        whenever(connectionManager.isNetworkAvailable()).thenReturn(false)
        database.storyDao().save(story.toEntity())
        database.previewDao().save(
            story.previewMedia.orEmpty()
                .map {
                    it.toEntity(storyId = story.storyId.zeroIfNull())
                }
        )
        database.characterDao().save(
            story.characters.orEmpty()
                .map {
                    it.toEntity(storyId = story.storyId.zeroIfNull())
                }
        )

        assert(!database.storyDao().countStories().isEmpty())
        assert(!database.characterDao().countCharacters().isEmpty())
        assert(!database.previewDao().countMedia().isEmpty())
    }

    companion object {
        private val character =
            Character(characterId = 1, image = Image(resourceUri = "uri"), name = "some name")
        private val media = PreviewMedia(resourceId = 1, resourceType = "video", resourceUri = "uri")

        val story = Story().apply {
            storyId = 1
            characters = listOf(character)
            fullSummary = "some summary"
            name = "some name"
            previewMedia = listOf(media)
            shortSummary = "Short summary"
        }
    }
}