package com.example.empresas_ioasys.injection

import com.example.empresas_ioasys.data.data_remote.enterprise.CompanyService
import com.example.empresas_ioasys.data.data_remote.login.LoginService
import org.koin.dsl.module

val dataRemoteModule = module {

    single { CompanyService.newInstance() }
    single { LoginService.newInstance() }
}