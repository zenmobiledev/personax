package com.mobbelldev.personax.utils

sealed class Response<out T> {
    data class Success<out T>(val data: T?) : Response<T>()
    data class Error(val message: String) : Response<Nothing>()
    data object Loading : Response<Nothing>()
}