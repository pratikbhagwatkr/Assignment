package com.example.assignment.domain.use_case

import com.example.assignment.domain.repository.GetCountryRepository
import com.example.assignment.mockCountriesModelList
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
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
    fun `getCountryList should get valid response`(){
        runBlockingTest {
            whenever(repository.getCountryList()).thenReturn(mockCountriesModelList)
            val res=usecase.getCountryList()
            verify(repository).getCountryList()
            assertEquals(mockCountriesModelList,res)
        }
    }







}