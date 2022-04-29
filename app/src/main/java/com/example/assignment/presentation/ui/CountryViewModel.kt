package com.example.assignment.presentation.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.assignment.common.Resource
import com.example.assignment.data.model.CountriesDTO
import com.example.assignment.data.model.toDomainCountries
import com.example.assignment.domain.model.Countries
import com.example.assignment.domain.use_case.GetCountryListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
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