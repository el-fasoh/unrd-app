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
package com.fasoh.unrd

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.fasoh.unrd.daos.CharacterEntityDao
import com.fasoh.unrd.daos.PreviewMediaDao
import com.fasoh.unrd.daos.StoryEntityDao
import com.fasoh.unrd.data.BuildConfig
import com.fasoh.unrd.entities.CharacterEntity
import com.fasoh.unrd.entities.PreviewMediaEntity
import com.fasoh.unrd.entities.StoryEntity

@Database(
    entities = [
        StoryEntity::class,
        PreviewMediaEntity::class,
        CharacterEntity::class
    ],
    version = 2
)
internal abstract class UnrdDatabase : RoomDatabase() {

    abstract fun characterDao(): CharacterEntityDao
    abstract fun previewDao(): PreviewMediaDao
    abstract fun storyDao(): StoryEntityDao

    companion object {
        private var database: UnrdDatabase? = null

        fun getInstance(context: Context): UnrdDatabase {
            database?.let {
                return database!!
            }
            return Room.databaseBuilder(context, UnrdDatabase::class.java, "unrd-database")
                .apply {
                    if (BuildConfig.DEBUG) {
                        fallbackToDestructiveMigration()
                    }
                }.build()
        }
    }
}