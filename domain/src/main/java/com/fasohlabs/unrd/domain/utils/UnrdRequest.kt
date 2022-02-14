package com.fasohlabs.unrd.domain.utils

sealed class UnrdRequest<out T> {

    data class Success<T>(val data: T) : UnrdRequest<T>()

    data class Error(val exception: Throwable = Exception(), val error: Any? = null) :
        UnrdRequest<Nothing>() {
        var message: String? = exception.message

        val isUnrdException: Boolean get() = exception is UnrdException
    }

    object Loading : UnrdRequest<Nothing>()

    companion object {
        fun error(exception: Throwable): Error {
            return Error(exception).apply { message = exception.message }
        }
    }
}