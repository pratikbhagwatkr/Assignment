package com.example.assignment.domain.use_case

import com.example.assignment.common.Resource
import com.example.assignment.data.model.toDomainCountries
import com.example.assignment.domain.model.Countries
import com.example.assignment.domain.repository.GetCountryRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import java.lang.Exception
import javax.inject.Inject

class GetCountryListUseCase @Inject constructor(private val repository: GetCountryRepository){



    suspend fun getData(): Resource<List<Countries>>{
        return try {

            val response = repository.getCountryList()
            val list =
                if (response.isNullOrEmpty()) emptyList<Countries>() else response.map { it.toDomainCountries() }
            Resource.Success(data = list)

        } catch (e: HttpException) {
            Resource.Error(message = e.localizedMessage ?: "Unknown Error")
        } catch (e: IOException) {
            Resource.Error(message = e.localizedMessage ?: "Check Internet Connection")
        } catch (e: Exception) {
            Resource.Error(message = e.localizedMessage ?: "Something went wrong")
        }

    }



}