package com.example.empresas_ioasys.data

import com.example.empresas_ioasys.Company
import com.example.empresas_ioasys.data.data_remote.ResultWrapper

interface EnterpriseRepository {
    suspend fun getEnterprises() : ResultWrapper<List<Company>>

}