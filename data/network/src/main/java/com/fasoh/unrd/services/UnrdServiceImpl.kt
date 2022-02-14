package com.fasoh.unrd.services

import com.fasoh.unrd.RetrofitUtil.safeApiCall
import com.fasoh.unrd.api.UnrdApi
import com.fasohlabs.unrd.domain.models.ApiResponseData
import com.fasohlabs.unrd.domain.models.ApiResult
import com.fasohlabs.unrd.domain.sercives.UnrdService
import com.fasohlabs.unrd.domain.utils.UnrdRequest
import javax.inject.Inject

internal class UnrdServiceImpl @Inject constructor(private val api: UnrdApi): UnrdService {
    override suspend fun fetchStories(): UnrdRequest<ApiResponseData> {
        return safeApiCall {
            api.fetchStory()
        }
    }
}