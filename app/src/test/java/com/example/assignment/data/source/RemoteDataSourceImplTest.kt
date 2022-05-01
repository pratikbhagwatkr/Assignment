package com.example.assignment.data.source

import com.example.assignment.data.model.CountriesDTO
import com.example.assignment.data.source.remote.service.ApiService
import com.example.assignment.mockCountriesDTOList
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

@ExperimentalCoroutinesApi
class RemoteDataSourceImplTest{

    @Mock
    lateinit var apiService: ApiService

    lateinit var remoteDataSourceImpl: RemoteDataSourceImpl

    @Before
    fun setup(){
        MockitoAnnotations.openMocks(this)
        remoteDataSourceImpl= RemoteDataSourceImpl(apiService)
    }


    @Test
    fun `on api call should return valid response`(){
        runBlockingTest {
            whenever(apiService.getCountries()).thenReturn(mockCountriesDTOList)
            val response=remoteDataSourceImpl.getCountryList()
            verify(apiService).getCountries()
            assertEquals(mockCountriesDTOList,response)
        }


    }

    @Test
    fun `on api call should return invalid response`(){
        runBlockingTest {
            whenever(apiService.getCountries()).thenReturn(emptyList<CountriesDTO>())
            val response=remoteDataSourceImpl.getCountryList()
            verify(apiService).getCountries()
            assertEquals(emptyList<CountriesDTO>(),response)
        }


    }


}