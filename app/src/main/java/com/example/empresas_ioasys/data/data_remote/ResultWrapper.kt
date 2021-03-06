package com.example.empresas_ioasys.data.data_remote

sealed class ResultWrapper<out Type>(
        val data: Type? = null,
        val error: Throwable? = null
) {

    class Success<Type>(data: Type) : ResultWrapper<Type>(data)
    class Failure(error: Throwable) : ResultWrapper<Nothing>(error = error)
}