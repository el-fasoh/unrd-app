package com.fasohlabs.unrd.domain.models

import com.google.gson.annotations.SerializedName

data class PurchasedItem(
    @SerializedName("exchange_key")
    var exchangeKey: Int? = null,
    @SerializedName("exchange_type")
    var exchangeType: String? = null
)