package com.example.empresas_ioasys.injection

import com.example.empresas_ioasys.presentation.LoginViewModel
import com.example.empresas_ioasys.presentation.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {

    viewModel { LoginViewModel(get()) }

    viewModel { MainViewModel(get()) }
}