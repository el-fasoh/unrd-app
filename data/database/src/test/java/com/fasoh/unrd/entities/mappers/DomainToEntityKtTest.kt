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

import com.fasohlabs.unrd.domain.models.Character
import com.fasohlabs.unrd.domain.models.Image
import com.fasohlabs.unrd.domain.models.PreviewMedia
import com.fasohlabs.unrd.domain.models.Story
import org.junit.Test

class DomainToEntityKtTest {

    @Test
    fun `test story to entity`() {
        val entity = story.toEntity()
        assert(
            story.characters.orEmpty().isNotEmpty() &&
                story.previewMedia.orEmpty().isNotEmpty() &&
                story.storyId == entity.storyId &&
                story.fullSummary == entity.fullSummary &&
                story.name == entity.name &&
                story.shortSummary == entity.shortSummary
        )
    }

    @Test
    fun `test character to entity`() {
        val entity = character.toEntity(1)
        assert(
            character.characterId == entity.characterId &&
                character.image != null &&
                character.name == entity.name
        )
    }

    @Test
    fun `test PreviewMedia to entity`() {
        val entity = media.toEntity(1)
        assert(
            media.resourceId == entity.resourceId &&
                media.resourceType == entity.resourceType &&
                media.resourceUri == entity.resourceUri
        )
    }

    companion object {
        val story = Story().apply {
            storyId = 1
            characters = listOf(character)
            fullSummary = "some summary"
            name = "some name"
            previewMedia = listOf(media)
            shortSummary = "Short summary"
        }

        val character =
            Character(characterId = 1, image = Image(resourceUri = "uri"), name = "some name")
        val media = PreviewMedia(resourceId = 1, resourceType = "video", resourceUri = "uri")
    }
}