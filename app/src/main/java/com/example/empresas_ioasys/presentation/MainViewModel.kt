package com.example.empresas_ioasys.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.empresas_ioasys.Company
import com.example.empresas_ioasys.data.EnterpriseRepository
import com.example.empresas_ioasys.data.data_remote.ResultWrapper
import com.example.empresas_ioasys.extensions.viewState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(
    private val repository : EnterpriseRepository
) : ViewModel() {

    private val _companyListLiveData by viewState<List<Company>>()
    val companyListLiveData: LiveData<ViewState<List<Company>>> = _companyListLiveData

    fun getCompanies() {
        _companyListLiveData.value = ViewState.loading(true)
        viewModelScope.launch (Dispatchers.Main) {
            handleResponse(repository.getEnterprises())
        }
    }


    private fun handleResponse(response: ResultWrapper<List<Company>>) {
        when(response){
            is ResultWrapper.Success -> _companyListLiveData.value =
                ViewState.success(response.data)
            is ResultWrapper.Failure -> _companyListLiveData.value = ViewState.error(response.error)
        }
        _companyListLiveData.value = ViewState.loading(false)
    }

}
