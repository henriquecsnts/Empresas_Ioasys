package com.example.empresas_ioasys.extensions

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.empresas_ioasys.presentation.ViewState

fun <T> ViewModel.viewState() = lazy{
    MutableLiveData<ViewState<T>>()
}