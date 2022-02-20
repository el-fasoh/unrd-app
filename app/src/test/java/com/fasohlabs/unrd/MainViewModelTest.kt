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
package com.fasohlabs.unrd

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.fasohlabs.unrd.domain.repositories.StoryRepository
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.mockito.kotlin.any
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

class MainViewModelTest {

    @Rule
    @JvmField
    val rule = InstantTaskExecutorRule()

    private val repository: StoryRepository = mock()

    private val viewModel: MainViewModel by lazy {
        MainViewModel(repository)
    }

    @Test
    fun `test fetch stories`() = runBlocking {
        whenever(repository.getStory()).thenReturn(flowOf(mock()))
        assertNotNull(viewModel.stories.getOrAwaitValue())
    }

    @Test
    fun `test fetch preview media`() = runBlocking {
        whenever(repository.getStory()).thenReturn(flowOf(mock()))
        whenever(repository.fetchMedia(any())).thenReturn(flowOf(mock()))
        val data = viewModel.fetchPreviewMedia(1).getOrAwaitValue()
        assertNotNull(data)
    }
}