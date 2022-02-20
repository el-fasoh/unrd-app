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
package com.fasohlabs.unrd.domain.utils

import com.fasohlabs.unrd.domain.exceptions.ApiException
import com.fasohlabs.unrd.domain.exceptions.ConnectionException

sealed class UnrdRequest<out T> {

    data class Success<T>(val data: T) : UnrdRequest<T>()

    data class Error(val exception: Throwable = Exception(), val error: Any? = null) :
        UnrdRequest<Nothing>() {
        var message: String? = exception.message

        val isUnrdException: Boolean get() = exception is UnrdException

        val isConnectionException: Boolean get() = exception is ConnectionException

        val isApiException: Boolean get() = exception is ApiException
    }

    object Loading : UnrdRequest<Nothing>()

    companion object {
        fun error(exception: Throwable) =
            Error(exception).apply { message = exception.message }
    }
}