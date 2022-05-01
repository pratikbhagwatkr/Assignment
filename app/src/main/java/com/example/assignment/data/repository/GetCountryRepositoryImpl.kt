package com.example.assignment.data.repository

import com.example.assignment.data.mapper.CountryResponseMapper
import com.example.assignment.data.source.DataSource
import com.example.assignment.domain.model.Countries
import com.example.assignment.domain.repository.GetCountryRepository
import javax.inject.Inject

class GetCountryRepositoryImpl @Inject constructor(private val remoteDataSource: DataSource.RemoteDataSource,
                                                   private val mapper: CountryResponseMapper): GetCountryRepository {

    override suspend fun getCountryList(): List<Countries> {
        return mapper.toDomainModel(remoteDataSource.getCountryList())
    }




}