package com.example.assignment.data.mapper

import com.example.assignment.domain.model.Countries
import com.example.assignment.mockCountriesDTOList
import com.example.assignment.mockCountriesModelList
import org.junit.Assert
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.reset

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