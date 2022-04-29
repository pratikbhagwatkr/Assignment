package com.example.assignment.data.repository

import com.example.assignment.data.mapper.CountryResponseMapper
import com.example.assignment.data.model.CountriesDTO
import com.example.assignment.data.model.toDomainCountries
import com.example.assignment.data.remote.ApiInterface
import com.example.assignment.domain.model.Countries
import com.example.assignment.domain.repository.GetCountryRepository
import javax.inject.Inject

class GetCountryRepositoryImpl @Inject constructor(private val apiInterface: ApiInterface,
   private val mapper: CountryResponseMapper): GetCountryRepository {

    override suspend fun getCountryList(): List<Countries> {
        return mapper.toDomainModel(apiInterface.getCountries())
    }




}