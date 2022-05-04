package com.example.data.data.repository


import com.example.data.data.source.DataSource
import com.example.domain.domain.model.Countries
import com.example.domain.domain.repository.GetCountryRepository
import javax.inject.Inject

class GetCountryRepositoryImpl @Inject constructor(private val remoteDataSource: DataSource.RemoteDataSource,

                                                   ): GetCountryRepository {

    override suspend fun getCountryList(): List<Countries> {
        return remoteDataSource.getCountryList()
    }




}