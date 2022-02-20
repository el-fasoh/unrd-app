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
package com.fasoh.unrd.entities.mappers

import com.fasoh.unrd.entities.CharacterEntity
import com.fasoh.unrd.entities.PreviewMediaEntity
import com.fasoh.unrd.entities.StoryEntity
import com.fasoh.unrd.entities.StoryMapped
import com.fasohlabs.unrd.domain.models.Character
import com.fasohlabs.unrd.domain.models.Image
import com.fasohlabs.unrd.domain.models.PreviewMedia
import com.fasohlabs.unrd.domain.models.Story

fun StoryEntity.toDomain() =
    Story(storyId, name = name, shortSummary = shortSummary, fullSummary = fullSummary)

fun CharacterEntity.toDomain() =
    Character(name = name, image = Image(resourceUri = resourceUri))

fun PreviewMediaEntity.toDomain(): PreviewMedia =
    PreviewMedia(resourceId = resourceId, resourceUri = resourceUri, resourceType = resourceType)

fun StoryMapped.toDomain() =
    this.storyEntity.toDomain().apply {
        characters = this@toDomain.characters.map { it.toDomain() }
        previewMedia = this@toDomain.media.map { it.toDomain() }
    }