package com.fasoh.unrd.api

import com.fasohlabs.unrd.domain.models.ApiResponseData
import retrofit2.Response
import retrofit2.http.GET

interface UnrdApi {

    @GET("/resp.json")
    suspend fun fetchStory(): Response<ApiResponseData>
}