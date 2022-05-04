package com.example.domain.domain.use_case

import com.example.domain.domain.model.Countries
import com.example.domain.domain.repository.GetCountryRepository
import com.example.domain.domain.resource.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import java.lang.Exception
import javax.inject.Inject

class GetCountryListUseCase @Inject constructor(private val repository: GetCountryRepository){

    fun getData(): Flow<Resource<List<Countries>>> =  flow{
         try {
             emit(Resource.Loading())
             val response = getCountryList()
             emit(Resource.Success(data = response))

        } catch (e: HttpException) {
            emit(Resource.Error(message = e.localizedMessage ?: "Unknown Error"))
        } catch (e: IOException) {
            emit(Resource.Error(message = e.localizedMessage ?: "Check Internet Connection"))
        } catch (e: Exception) {
            emit(Resource.Error(message = e.localizedMessage ?: "Something went wrong"))
        }
    }

   suspend fun getCountryList():List<Countries>{
       return repository.getCountryList()
    }
}