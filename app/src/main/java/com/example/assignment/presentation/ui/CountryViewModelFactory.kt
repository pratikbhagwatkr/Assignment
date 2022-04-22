package com.example.assignment.presentation.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.assignment.domain.use_case.GetCountryListUseCase
import javax.inject.Inject

class CountryViewModelFactory @Inject constructor(private val countryListUseCase: GetCountryListUseCase):
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        return CountryViewModel(countryListUseCase) as T
    }
}