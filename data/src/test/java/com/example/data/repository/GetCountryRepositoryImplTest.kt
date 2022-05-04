package com.example.data.repository


import com.example.data.data.repository.GetCountryRepositoryImpl
import com.example.data.data.source.DataSource
import com.example.data.mockCountriesModelList
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



    lateinit var repository: GetCountryRepositoryImpl

    @Before
    fun setup(){
        MockitoAnnotations.openMocks(this)
        repository= GetCountryRepositoryImpl(remoteDataSource)
    }


    @Test
    fun `on getCountryList get mapped list`(){
        runBlockingTest {
            whenever(remoteDataSource.getCountryList()).thenReturn(mockCountriesModelList)
            val response=repository.getCountryList()
            verify(remoteDataSource).getCountryList()
            assertEquals(
                mockCountriesModelList,
                response
            )

        }
    }




}