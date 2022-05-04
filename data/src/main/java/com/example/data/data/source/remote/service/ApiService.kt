package com.example.data.data.source.remote.service

import com.example.data.data.entity.CountriesDTO
import retrofit2.http.GET

interface ApiService {

        @GET("all")
        suspend fun getCountries():List<CountriesDTO>

}