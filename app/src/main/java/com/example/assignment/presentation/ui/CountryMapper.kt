package com.example.assignment.presentation.ui

import com.example.assignment.data.model.CountriesDTO
import com.example.assignment.data.model.toDomainCountries
import com.example.assignment.domain.model.Countries

object CountryMapper {

    fun toModel(response: List<CountriesDTO>?): List<Countries> {
        return if (response.isNullOrEmpty()) emptyList() else response.map {
            it.toDomainCountries()
        }
    }
}
