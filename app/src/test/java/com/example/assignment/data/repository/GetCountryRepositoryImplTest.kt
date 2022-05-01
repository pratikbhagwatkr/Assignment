package com.example.assignment.data.repository

import com.example.assignment.data.mapper.CountryResponseMapper
import com.example.assignment.data.source.DataSource
import com.example.assignment.mockCountriesDTOList
import com.example.assignment.mockCountriesModelList
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
    private lateinit var remoteDataSource: DataSource.RemoteDataSource

    @Mock
    private lateinit var mapper: CountryResponseMapper

    lateinit var repository: GetCountryRepositoryImpl

    @Before
    fun setup(){
        MockitoAnnotations.openMocks(this)
        repository= GetCountryRepositoryImpl(remoteDataSource,mapper)
    }


    @Test
    fun `on getCountryList get mapped list`(){
        runBlockingTest {
            whenever(remoteDataSource.getCountryList()).thenReturn(mockCountriesDTOList)
            whenever(mapper.toDomainModel(mockCountriesDTOList)).thenReturn(mockCountriesModelList)
            val response=repository.getCountryList()
            verify(mapper).toDomainModel(mockCountriesDTOList)
            assertEquals(
                mockCountriesModelList,
                response
            )

        }
    }




}