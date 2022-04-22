package com.example.assignment.data.remote

import com.example.assignment.data.model.CountriesDTO
import retrofit2.http.GET

interface ApiInterface {

    @GET("all")
    suspend fun getCountries():List<CountriesDTO>
}