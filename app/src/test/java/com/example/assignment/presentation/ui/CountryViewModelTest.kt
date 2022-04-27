package com.example.assignment.presentation.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.assignment.domain.use_case.GetCountryListUseCase
import kotlinx.coroutines.runBlocking

import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.*
import org.junit.*
import org.mockito.kotlin.*

@ExperimentalCoroutinesApi
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
  fun `on api call get valid input`(){

    runBlockingTest {
      whenever(
        getCountryListUseCase.getDataa()
      ).thenReturn(
        mockCountriesDTOList
      )

      whenever(viewModel.mapRespons(anyOrNull())).thenReturn(mockCountriesModelList)
      viewModel.getCountryListt()
      val response=viewModel.countryList.value
      verify(viewModel).getCountryListt()
      Assert.assertEquals(mockCountriesModelList, response)


    }

  }

  @After
  fun cleanUp() {
    Dispatchers.resetMain()
    testDispatcher.cleanupTestCoroutines()
    testScope.cleanupTestCoroutines()
  }




}