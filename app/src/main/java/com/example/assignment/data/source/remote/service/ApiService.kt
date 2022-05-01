package com.example.assignment.data.source.remote.service

import com.example.assignment.data.model.CountriesDTO
import retrofit2.http.GET

interface ApiService {

        @GET("all")
        suspend fun getCountries():List<CountriesDTO>

}