package com.example.empresas_ioasys.data

import com.example.empresas_ioasys.data.data_remote.ResultWrapper
import okhttp3.Headers

interface LoginRepository {
    suspend fun login(email: String, password: String) : ResultWrapper<Unit>
}