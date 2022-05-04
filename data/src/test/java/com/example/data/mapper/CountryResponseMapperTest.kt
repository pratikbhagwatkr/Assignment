package com.example.data.mapper

import com.example.data.data.mapper.CountryResponseMapper
import com.example.data.mockCountriesDTOList
import com.example.data.mockCountriesModelList
import com.example.domain.domain.model.Countries
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class CountryResponseMapperTest{

    lateinit var mapper: CountryResponseMapper

    @Before
    fun setup(){
        mapper= CountryResponseMapper()
    }

    @Test
    fun `toDomainModel map CountryDTO response to valid Countries`(){
        val response=mapper.toDomainModel(mockCountriesDTOList)
        assertEquals(mockCountriesModelList,response)
    }

    @Test
    fun `toModel map CountryDTO response to invalid Countries`() {
        val response = mapper.toDomainModel(null)
        assertEquals(emptyList<Countries>(),response)
    }

}