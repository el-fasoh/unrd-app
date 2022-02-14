package com.fasohlabs.unrd.domain.models


import com.google.gson.annotations.SerializedName

data class Timeline(
    @SerializedName("chats")
    var chats: List<Chat>? = null,
    @SerializedName("created")
    var created: String? = null,
    @SerializedName("events")
    var events: List<Event>? = null,
    @SerializedName("is_primary")
    var isPrimary: Boolean? = null,
    @SerializedName("is_terminal")
    var isTerminal: Boolean? = null,
    @SerializedName("name")
    var name: String? = null,
    @SerializedName("timeline_id")
    var timelineId: Int? = null,
    @SerializedName("updated")
    var updated: String? = null
)