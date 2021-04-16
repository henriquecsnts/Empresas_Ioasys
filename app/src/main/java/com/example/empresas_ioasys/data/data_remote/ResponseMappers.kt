package com.example.empresas_ioasys.data.data_remote

import com.example.empresas_ioasys.Company
import com.example.empresas_ioasys.CompanyType
import com.example.empresas_ioasys.data.data_remote.enterprise.CompanyResponse
import com.example.empresas_ioasys.data.data_remote.enterprise.CompanyTypeResponse

fun CompanyResponse.toModel(): Company {
    return Company(
            id = id,
            companyName = enterpriseName,
            pathImage = "https://thispersondoesnotexist.com/image",
            description = description,
            country = country ?: "",
            companyType = enterpriseType.toModel()
    )
}

fun CompanyTypeResponse.toModel(): CompanyType {
    return CompanyType(
            id = id,
            companyTypeName = enterpriseTypeName
    )
}