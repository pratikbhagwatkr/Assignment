package com.example.assignment.data.source

import com.example.assignment.data.model.CountriesDTO
import com.example.assignment.domain.model.Countries

interface DataSource {
    interface RemoteDataSource{
        suspend fun getCountryList():List<CountriesDTO>
    }
}