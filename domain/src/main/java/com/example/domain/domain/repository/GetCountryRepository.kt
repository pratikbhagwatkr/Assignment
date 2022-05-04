package com.example.domain.domain.repository


import com.example.domain.domain.model.Countries

interface GetCountryRepository {

    suspend fun getCountryList():List<Countries>
}