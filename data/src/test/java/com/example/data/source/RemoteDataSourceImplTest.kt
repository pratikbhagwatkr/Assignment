package com.example.data.source


import com.example.data.data.entity.CountriesDTO
import com.example.data.data.mapper.CountryResponseMapper
import com.example.data.data.source.RemoteDataSourceImpl
import com.example.data.data.source.remote.service.ApiService
import com.example.data.mockCountriesDTOList
import com.example.data.mockCountriesModelList
import com.example.domain.domain.model.Countries
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

    @Mock
    lateinit var mapper: CountryResponseMapper

    lateinit var remoteDataSourceImpl: RemoteDataSourceImpl

    @Before
    fun setup(){
        MockitoAnnotations.openMocks(this)
        remoteDataSourceImpl= RemoteDataSourceImpl(apiService,mapper)
    }


    @Test
    fun `on api call should return valid response`(){
        runBlockingTest {
            whenever(apiService.getCountries()).thenReturn(mockCountriesDTOList)
            whenever(mapper.toDomainModel(mockCountriesDTOList)).thenReturn(mockCountriesModelList)
            val response=remoteDataSourceImpl.getCountryList()
            verify(mapper).toDomainModel(mockCountriesDTOList)
            assertEquals(mockCountriesModelList,response)
        }


    }

    @Test
    fun `on api call should return invalid response`(){
        runBlockingTest {
            whenever(apiService.getCountries()).thenReturn(emptyList<CountriesDTO>())
            whenever(mapper.toDomainModel(emptyList<CountriesDTO>())).thenReturn(emptyList<Countries>())
            val response=remoteDataSourceImpl.getCountryList()
            verify(mapper).toDomainModel(emptyList<CountriesDTO>())
            assertEquals(emptyList<Countries>(),response)
        }


    }


}