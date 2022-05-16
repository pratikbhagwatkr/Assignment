package com.example.domain.usecases


import com.example.domain.domain.repository.GetCountryRepository
import com.example.domain.domain.use_case.GetCountryListUseCase
import com.example.domain.mockCountriesModelList
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
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