package com.example.assignment.domain.use_case

import com.example.assignment.common.Resource
import com.example.assignment.data.model.toDomainCountries
import com.example.assignment.domain.model.Countries
import com.example.assignment.domain.repository.GetCountryRepository
import com.example.assignment.presentation.ui.mockCountriesDTOList
import com.example.assignment.presentation.ui.mockCountriesModelList
import com.example.assignment.presentation.ui.mockCountryDTO
import com.google.common.truth.Truth
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.any
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

@ExperimentalCoroutinesApi
class GetCountryListUseCaseTest{

    @Mock
    lateinit var repository: GetCountryRepository

    lateinit var usecase: GetCountryListUseCase

    @Before
    fun setup(){
        MockitoAnnotations.openMocks(this)
        usecase= GetCountryListUseCase(repository)

    }


    @Test
    fun `getCountryList should get valid response`(){
        runBlockingTest {
            whenever(repository.getCountryList()).thenReturn(mockCountriesModelList)
            val res=usecase.getCountryList()
            verify(repository).getCountryList()
            assertEquals(mockCountriesModelList,res)
        }
    }

    @Test
    fun `getData should return valid data as flow`(){
        runBlockingTest {
            whenever(repository.getCountryList()).thenReturn(mockCountriesModelList)
            val res=usecase.getData().first()
            assertEquals(Resource.Success(mockCountriesModelList), res)

        }
    }





}