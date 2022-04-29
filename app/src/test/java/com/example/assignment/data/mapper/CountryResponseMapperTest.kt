package com.example.assignment.data.mapper

import com.example.assignment.presentation.ui.mockCountriesDTOList
import com.example.assignment.presentation.ui.mockCountriesModelList
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.whenever

class CountryResponseMapperTest{

    lateinit var mapper: CountryResponseMapper

    @Before
    fun setup(){
        mapper= CountryResponseMapper()
    }

    @Test
    fun `map CountryDTO response to Countries`(){
        val response=mapper.toDomainModel(mockCountriesDTOList)
        assertEquals(mockCountriesModelList,response)
    }

}