package com.fasoh.unrd.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "stories")
data class StoryEntity (

    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "story_id")
    var storyId: Long? = null,

    var name: String,

    @ColumnInfo(name = "short_summary")
    var shortSummary: String? = null,

    @ColumnInfo(name = "full_summary")
    var fullSummary: String? = null
)