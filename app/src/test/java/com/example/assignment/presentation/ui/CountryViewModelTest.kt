package com.example.assignment.presentation.ui

import com.bumptech.glide.load.engine.Resource
import com.example.assignment.domain.model.Countries
import com.example.assignment.domain.use_case.GetCountryListUseCase
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.any
import org.mockito.kotlin.whenever
import org.mockito.stubbing.OngoingStubbing

@RunWith(JUnit4::class)
class CountryViewModelTest {


    @Mock
    private lateinit var countryListUseCase: GetCountryListUseCase



    @Before
    fun before() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun checkResult(){

        runBlocking {
            whenever(
                countryListUseCase.getData()
            ).thenReturn(
               any()
            )

        }

    }


}


