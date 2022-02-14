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