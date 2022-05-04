package com.example.data.data.mapper

import com.example.data.data.entity.CountriesDTO
import com.example.data.data.entity.toDomainCountries
import com.example.domain.domain.model.Countries
import javax.inject.Inject


class CountryResponseMapper @Inject constructor() {

    fun toDomainModel(response:List<CountriesDTO>?) : List<Countries>{
        return  if (response.isNullOrEmpty()) emptyList<Countries>()
        else response.map { it.toDomainCountries() }
    }
}