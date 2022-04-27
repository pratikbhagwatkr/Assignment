package com.example.assignment.domain.use_case

import com.example.assignment.data.model.toDomainCountries
import com.example.assignment.domain.repository.GetCountryRepository
import com.example.assignment.presentation.ui.mockCountriesDTOList
import com.example.assignment.presentation.ui.mockCountriesModelList
import com.example.assignment.presentation.ui.mockCountryDTO
import com.google.common.truth.Truth
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.MockitoAnnotations
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
    fun `getData should call repository`(){
        runBlockingTest {

            whenever(repository.getCountryList()).thenReturn(mockCountriesDTOList)
            val response = usecase.getDataa()
            verify(repository).getCountryList()
            Assert.assertEquals(mockCountriesDTOList, response)

        }


    }



}