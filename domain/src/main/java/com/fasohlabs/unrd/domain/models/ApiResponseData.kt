package com.fasohlabs.unrd.domain.models


import com.google.gson.annotations.SerializedName

data class ApiResponseData(
    @SerializedName("result")
    var result: ApiResult? = null,
    @SerializedName("status")
    var status: Status
)