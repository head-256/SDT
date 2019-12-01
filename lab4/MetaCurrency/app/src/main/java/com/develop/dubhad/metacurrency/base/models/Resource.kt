package com.develop.dubhad.metacurrency.base.models

data class Resource<out T>(
    val status: Status,
    private val resData: T?,
    private val resErrorMessage: String?
) {

    val data: T
        get() = resData ?: throw IllegalStateException("There is no data")

    val errorMessage: String
        get() = resErrorMessage ?: throw IllegalStateException("There is no error")

    companion object {
        fun <T> success(data: T?) = Resource(
            Status.SUCCESS,
            data,
            null
        )

        fun error(message: String) = Resource(
            Status.ERROR,
            null,
            message
        )

        fun loading() = Resource(
            Status.LOADING,
            null,
            null
        )
    }
}
