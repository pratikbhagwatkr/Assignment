package com.example.assignment.presentation.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.domain.resource.Resource
import com.example.domain.domain.use_case.GetCountryListUseCase

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CountryViewModel @Inject constructor (private val countryListUseCase: GetCountryListUseCase):ViewModel(){

    private val _countryState= MutableStateFlow<CountryState>(CountryState())
    val countryState:StateFlow<CountryState> = _countryState

    fun getCountryList() {

            countryListUseCase.getData().onEach {
                    when(it){
                        is Resource.Success -> {
                            _countryState.value= CountryState(data = it.data ?: emptyList())
                        }
                        is Resource.Error -> {
                            _countryState.value= CountryState(error = it.message ?: "Something went wrong please try again")
                        }
                        is Resource.Loading -> {
                            _countryState.value= CountryState(isLoading = true)
                        }
                    }
            }.launchIn(viewModelScope)

    }






}