package com.fasohlabs.unrd.domain.models


import com.google.gson.annotations.SerializedName

data class Media(
    @SerializedName("resource_fid")
    var resourceFid: String? = null,
    @SerializedName("resource_id")
    var resourceId: Int? = null,
    @SerializedName("resource_preset")
    var resourcePreset: String? = null,
    @SerializedName("resource_processed")
    var resourceProcessed: Boolean? = null,
    @SerializedName("resource_progress")
    var resourceProgress: Int? = null,
    @SerializedName("resource_type")
    var resourceType: String? = null,
    @SerializedName("resource_uri")
    var resourceUri: String? = null
)