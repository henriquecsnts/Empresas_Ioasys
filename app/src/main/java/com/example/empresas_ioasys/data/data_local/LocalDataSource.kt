package com.example.empresas_ioasys.data.data_local

import okhttp3.Headers

interface LocalDataSource {

    suspend fun saveToLocalDatabase(headers: Headers)

    suspend fun getFromLocalDatabase() : Headers

    fun saveHeadersToPreferences(headers: Headers)

    fun getHeadersFromPreferences() : Headers
}