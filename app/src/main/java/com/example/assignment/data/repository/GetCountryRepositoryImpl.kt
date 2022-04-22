package com.example.assignment.data.repository

import com.example.assignment.data.model.CountriesDTO
import com.example.assignment.data.remote.ApiInterface
import com.example.assignment.domain.repository.GetCountryRepository
import javax.inject.Inject

class GetCountryRepositoryImpl @Inject constructor(private val apiInterface: ApiInterface): GetCountryRepository {

    override suspend fun getCountryList(): List<CountriesDTO> {
         return apiInterface.getCountries()
    }
}