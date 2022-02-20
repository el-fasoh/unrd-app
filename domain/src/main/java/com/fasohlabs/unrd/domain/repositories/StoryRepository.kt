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
package com.fasohlabs.unrd.domain.repositories

import com.fasohlabs.unrd.domain.models.PreviewMedia
import com.fasohlabs.unrd.domain.models.Story
import com.fasohlabs.unrd.domain.utils.UnrdRequest
import kotlinx.coroutines.flow.Flow

interface StoryRepository {

    fun getStory(): Flow<UnrdRequest<Story>>

    fun fetchMedia(storyId: Long): Flow<List<PreviewMedia>>
}