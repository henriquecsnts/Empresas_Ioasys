package com.example.empresas_ioasys

import android.app.Application
import com.example.empresas_ioasys.injection.dataLocalModule
import com.example.empresas_ioasys.injection.dataModule
import com.example.empresas_ioasys.injection.dataRemoteModule
import com.example.empresas_ioasys.injection.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class EmpresasApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        setupKoin()
    }

    private fun setupKoin() {
        startKoin {
            androidContext(this@EmpresasApplication)
            modules(listOf(
                presentationModule,
                dataModule,
                dataLocalModule,
                dataRemoteModule
            )
            )
        }
    }
}