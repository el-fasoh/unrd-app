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
import org.junit.Test

class EntityToDomainKtTest {

    @Test
    fun `test StoryEntity to domain`() {
        val domain = story.toDomain()
        assert(
            story.storyId == domain.storyId &&
                story.fullSummary == domain.fullSummary &&
                story.name == domain.name &&
                story.shortSummary == domain.shortSummary
        )
    }

    @Test
    fun `test CharacterEntity to domain`() {
        val domain = character.toDomain()
        assert(
            character.name == domain.name &&
                character.resourceUri == domain.image?.resourceUri
        )
    }

    @Test
    fun `test PreviewMedia to domain`() {
        val domain = media.toDomain()
        assert(
            media.resourceType == domain.resourceType &&
                media.resourceUri == domain.resourceUri
        )
    }

    companion object {
        val story = StoryEntity().apply {
            storyId = 1
            fullSummary = "some summary"
            name = "some name"
            shortSummary = "Short summary"
        }

        val character =
            CharacterEntity(characterId = 1, resourceUri = "uri", name = "some name", storyId = 1)
        val media = PreviewMediaEntity(resourceId = 1, resourceType = "video", resourceUri = "uri")
    }
}