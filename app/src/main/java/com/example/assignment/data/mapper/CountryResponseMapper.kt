package com.example.assignment.data.mapper

import com.example.assignment.data.model.CountriesDTO
import com.example.assignment.data.model.toDomainCountries
import com.example.assignment.domain.model.Countries
import javax.inject.Inject

class CountryResponseMapper @Inject constructor() {

    fun toDomainModel(response:List<CountriesDTO>?) : List<Countries>{
        return  if (response.isNullOrEmpty()) emptyList<Countries>()
        else response.map { it.toDomainCountries() }
    }
}