package com.fasohlabs.unrd.domain.models


import com.google.gson.annotations.SerializedName

data class Event(
    @SerializedName("data")
    var `data`: Data? = null,
    @SerializedName("has_options")
    var hasOptions: Boolean? = null,
    @SerializedName("sequence")
    var sequence: Int? = null,
    @SerializedName("type")
    var type: String? = null
)