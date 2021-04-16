package com.example.empresas_ioasys.data.data_remote.enterprise

import com.google.gson.annotations.SerializedName

data class GetCompaniesResponse (

    @SerializedName("enterprises")
    val companies: List<CompanyResponse>
)