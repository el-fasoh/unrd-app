package com.fasoh.unrd.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "characters")
data class CharacterEntity(

    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "character_id")
    var characterId: Int? = null,

    @ColumnInfo(name = "resource_uri")
    var resourceUri: String? = null,

    var name: String? = null
)