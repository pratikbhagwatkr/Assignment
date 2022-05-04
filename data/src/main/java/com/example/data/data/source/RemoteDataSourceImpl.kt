package com.example.data.data.source

import com.example.data.data.source.remote.service.ApiService
import com.example.data.data.mapper.CountryResponseMapper
import com.example.data.data.source.DataSource
import com.example.domain.domain.model.Countries
import java.lang.Exception
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(private val apiInterface: ApiService,
                                               private val mapper: CountryResponseMapper) : DataSource.RemoteDataSource {

    override suspend fun getCountryList(): List<Countries> =
        try {
             mapper.toDomainModel(apiInterface.getCountries())
        } catch(e:Exception) {
            emptyList<Countries>()
        }

}
