package com.example.assignment.presentation.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.assignment.common.Resource
import com.example.assignment.domain.model.Countries
import com.example.assignment.domain.use_case.GetCountryListUseCase
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class CountryViewModel (private val countryListUseCase: GetCountryListUseCase):ViewModel(){


    val errorMessage=MutableLiveData<String>()
    val loading=MutableLiveData<Boolean>()
    private val _countryRes=MutableLiveData<List<Countries>>()
    val countryList:LiveData<List<Countries>> = _countryRes

    val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        onError("Exception handled: ${throwable.localizedMessage}")
    }


    fun getCountryList() {
        loading.value=true
        viewModelScope.launch(Dispatchers.IO + exceptionHandler) {
            val response=countryListUseCase.getData()
            withContext(Dispatchers.Main) {
                when(response){
                    is Resource.Success -> {
                        loading.value=false
                        _countryRes.value= response.data ?: emptyList()
                    }
                    is Resource.Error -> {
                        loading.value=false
                         onError(response.message ?: "Something went wrong please try again")
                    }
                }
            }
        }
    }


    private fun onError(message: String) {
        errorMessage.value=message
        loading.value=false
    }
}