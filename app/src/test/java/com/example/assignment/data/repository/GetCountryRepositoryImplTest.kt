package com.example.assignment.data.repository

import com.example.assignment.data.remote.ApiInterface
import com.example.assignment.presentation.ui.mockCountriesDTOList
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
class GetCountryRepositoryImplTest{

    @Mock
    private lateinit var apiInterface: ApiInterface

    lateinit var repository: GetCountryRepositoryImpl

    @Before
    fun setup(){
        MockitoAnnotations.openMocks(this)
        repository= GetCountryRepositoryImpl(apiInterface)
    }


    @Test
    fun `do test`(){
        runBlockingTest {
            whenever(apiInterface.getCountries()).thenReturn(mockCountriesDTOList)
            val response = repository.getCountryList()
            verify(apiInterface).getCountries()
            assertEquals(
                mockCountriesDTOList,
                response
            )

        }
    }




}