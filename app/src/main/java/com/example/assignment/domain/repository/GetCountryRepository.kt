package com.example.assignment.domain.repository

import com.example.assignment.data.model.CountriesDTO

interface GetCountryRepository {

    suspend fun getCountryList():List<CountriesDTO>
}