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
package com.fasoh.unrd

import com.fasohlabs.unrd.domain.utils.UnrdException
import com.fasohlabs.unrd.domain.utils.UnrdRequest
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import timber.log.Timber

object RetrofitUtil {
    suspend inline fun <T> safeApiCall(
        crossinline responseFunction: suspend () -> Response<T>
    ): UnrdRequest<T> {
        return try {
            val response = withContext(Dispatchers.IO) { responseFunction.invoke() }
            when {
                response.isSuccessful && response.body() != null -> UnrdRequest.Success(response.body()!!)
                response.errorBody() != null -> {
                    val error: String = response.errorBody()!!.string()
                    UnrdRequest.error(Gson().fromJson(error, UnrdException::class.java))
                }
                else -> UnrdRequest.error(UnrdException(message = "Unable to complete request"))
            }
        } catch (e: Exception) {
            Timber.e(e)
            UnrdRequest.error(e)
        }
    }
}