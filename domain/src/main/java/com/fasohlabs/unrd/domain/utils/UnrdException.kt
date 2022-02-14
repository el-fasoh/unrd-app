package com.fasohlabs.unrd.domain.utils

class UnrdException(
    override val message: String,
    val status: Int = -1,
    val path: String = "",
    val error: String = ""
) : Throwable(message)