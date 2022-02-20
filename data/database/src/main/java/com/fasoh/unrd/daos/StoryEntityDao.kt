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
import androidx.room.Transaction
import com.fasoh.unrd.entities.StoryEntity
import com.fasoh.unrd.entities.StoryMapped
import kotlinx.coroutines.flow.Flow

@Dao
interface StoryEntityDao : BaseDao<StoryEntity> {

    @Query(value = "select count(*) from stories")
    suspend fun countStories(): Int

    @Transaction
    @Query(value = "select * from stories")
    fun fetchStories(): Flow<List<StoryMapped>>
}