package com.fasohlabs.unrd.domain.sercives

import com.fasohlabs.unrd.domain.models.ApiResponseData
import com.fasohlabs.unrd.domain.utils.UnrdRequest

interface UnrdService {
    suspend fun fetchStories(): UnrdRequest<ApiResponseData>
}