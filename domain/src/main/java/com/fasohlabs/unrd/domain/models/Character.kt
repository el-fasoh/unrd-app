package com.fasohlabs.unrd.domain.models


import com.google.gson.annotations.SerializedName

data class Character(
    @SerializedName("character_id")
    var characterId: Int? = null,
    @SerializedName("image")
    var image: Image? = null,
    @SerializedName("is_main")
    var isMain: Boolean? = null,
    @SerializedName("name")
    var name: String? = null
)