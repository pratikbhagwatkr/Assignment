package com.example.assignment.domain.repository

import com.example.assignment.data.model.CountriesDTO
import com.example.assignment.domain.model.Countries

interface GetCountryRepository {

    suspend fun getCountryList():List<Countries>
}