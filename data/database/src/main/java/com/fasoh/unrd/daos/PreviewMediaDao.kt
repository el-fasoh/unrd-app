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
package com.fasoh.unrd.daos

import androidx.room.Dao
import androidx.room.Query
import com.fasoh.unrd.entities.PreviewMediaEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PreviewMediaDao : BaseDao<PreviewMediaEntity> {

    @Query(value = "select count(*) from preview_media")
    suspend fun countMedia(): Int

    @Query(value = "select * from preview_media where story_id =:storyId")
    fun fetchPreviewMediaByStoryId(storyId: Long): Flow<List<PreviewMediaEntity>>
}