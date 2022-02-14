package com.fasohlabs.unrd.domain.models

import com.google.gson.annotations.SerializedName

data class Chat(
    @SerializedName("chat_id")
    var chatId: Int? = null,
    @SerializedName("display_name")
    var displayName: String? = null,
    @SerializedName("is_group")
    var isGroup: Boolean? = null,
    @SerializedName("is_locked")
    var isLocked: Boolean? = null,
    @SerializedName("name")
    var name: String? = null,
    @SerializedName("owned")
    var owned: Any? = null,
    @SerializedName("price")
    var price: Int? = null,
    @SerializedName("timeline_id")
    var timelineId: Int? = null
)