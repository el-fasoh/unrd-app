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
package com.fasoh.unrd.entities

import androidx.room.Embedded
import androidx.room.Relation

class StoryMapped(

    @Embedded
    var storyEntity: StoryEntity,

    @Relation(
        parentColumn = "story_id",
        entityColumn = "story_id"
    )
    var characters: List<CharacterEntity>,

    @Relation(
        parentColumn = "story_id",
        entityColumn = "story_id"
    )
    var media: List<PreviewMediaEntity>
)