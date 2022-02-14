package com.fasohlabs.unrd.domain.models

import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("background_colour")
    var backgroundColour: String? = null,
    @SerializedName("character_id")
    var characterId: Int? = null,
    @SerializedName("character_share_id")
    var characterShareId: Int? = null,
    @SerializedName("chat_action_id")
    var chatActionId: Int? = null,
    @SerializedName("chat_id")
    var chatId: Int? = null,
    @SerializedName("chat_message_id")
    var chatMessageId: Int? = null,
    @SerializedName("content")
    var content: String? = null,
    @SerializedName("created")
    var created: String? = null,
    @SerializedName("duration")
    var duration: Int? = null,
    @SerializedName("has_options")
    var hasOptions: Boolean? = null,
    @SerializedName("has_url")
    var hasUrl: Boolean? = null,
    @SerializedName("is_live")
    var isLive: Boolean? = null,
    @SerializedName("is_locked")
    var isLocked: Boolean? = null,
    @SerializedName("is_public")
    var isPublic: Boolean? = null,
    @SerializedName("media")
    var media: List<Media>? = null,
    @SerializedName("media_duration")
    var mediaDuration: Any? = null,
    @SerializedName("options_timeout")
    var optionsTimeout: Int? = null,
    @SerializedName("owned")
    var owned: Any? = null,
    @SerializedName("price")
    var price: Int? = null,
    @SerializedName("resource_id")
    var resourceId: Any? = null,
    @SerializedName("sequence")
    var sequence: Int? = null,
    @SerializedName("stream_path")
    var streamPath: Any? = null,
    @SerializedName("thumb")
    var thumb: List<Thumb>? = null,
    @SerializedName("thumb_resource_id")
    var thumbResourceId: Any? = null,
    @SerializedName("updated")
    var updated: String? = null,
    @SerializedName("url_label")
    var urlLabel: Any? = null
)