package com.example.assignment.presentation.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.assignment.mockCountriesModelList
import com.example.domain.domain.model.Countries
import com.example.domain.domain.resource.Resource
import com.example.domain.domain.use_case.GetCountryListUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.*
import org.junit.*
import org.junit.Assert.*
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

class CountryViewModelTest{

    @get:Rule
    val rule = InstantTaskExecutorRule()
    val testDispatcher = TestCoroutineDispatcher()
    val testScope = TestCoroutineScope(testDispatcher)
    @Mock
    lateinit var getCountryListUseCase: GetCountryListUseCase



    lateinit var viewModel: CountryViewModel

    @Before
    fun setup(){

        MockitoAnnotations.openMocks(this)
        Dispatchers.setMain(testDispatcher)
        viewModel= CountryViewModel(getCountryListUseCase)

    }

    @Test
    fun `on method call get valid output`(){

        runBlockingTest {
            whenever(getCountryListUseCase.getData()).thenReturn(
                flow {
                    emit(Resource.Success(mockCountriesModelList))
                }
            )

            viewModel.getCountryList()

            verify(getCountryListUseCase).getData()

            assertEquals(mockCountriesModelList, viewModel.countryState.value.data)

        }

    }

    @Test
    fun `on method call get invalid output`(){

        runBlockingTest {
            whenever(getCountryListUseCase.getData()).thenReturn(
                flow {
                    emit(Resource.Success(emptyList<Countries>()))
                }
            )

            viewModel.getCountryList()

            verify(getCountryListUseCase).getData()

            assertEquals(emptyList<Countries>(), viewModel.countryState.value.data)

        }

    }


    @After
    fun cleanUp() {
        Dispatchers.resetMain()
        testDispatcher.cleanupTestCoroutines()
        testScope.cleanupTestCoroutines()
    }





}