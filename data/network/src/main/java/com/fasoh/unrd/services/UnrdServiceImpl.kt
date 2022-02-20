/*
 * Copyright 2022 Unrd
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.fasoh.unrd.services

import com.fasoh.unrd.RetrofitUtil.safeApiCall
import com.fasoh.unrd.api.UnrdApi
import com.fasohlabs.unrd.domain.models.ApiResponseData
import com.fasohlabs.unrd.domain.sercives.UnrdService
import com.fasohlabs.unrd.domain.utils.UnrdRequest
import javax.inject.Inject

internal class UnrdServiceImpl @Inject constructor(private val api: UnrdApi) : UnrdService {
    override suspend fun fetchStories(): UnrdRequest<ApiResponseData> {
        return safeApiCall {
            api.fetchStory()
        }
    }
}