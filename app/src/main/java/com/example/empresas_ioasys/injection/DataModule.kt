package com.example.empresas_ioasys.injection

import com.example.empresas_ioasys.data.EnterpriseRepository
import com.example.empresas_ioasys.data.LoginRepository
import com.example.empresas_ioasys.data.data_remote.enterprise.EnterpriseRepositoryImpl
import com.example.empresas_ioasys.data.data_remote.login.LoginRepositoryImpl
import org.koin.dsl.module

val dataModule = module {
    single<LoginRepository> { LoginRepositoryImpl(get(),get()) }
    single<EnterpriseRepository> { EnterpriseRepositoryImpl(get(),get()) }
}