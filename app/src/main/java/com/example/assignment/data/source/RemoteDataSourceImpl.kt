package com.example.assignment.data.source

import com.example.assignment.data.model.CountriesDTO
import com.example.assignment.data.source.remote.service.ApiService
import java.lang.Exception
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(private val apiInterface: ApiService) : DataSource.RemoteDataSource {

    override suspend fun getCountryList(): List<CountriesDTO> =
        try {
             apiInterface.getCountries()
        } catch(e:Exception) {
            emptyList<CountriesDTO>()
        }

}
