package com.example.data.data.source


import com.example.domain.domain.model.Countries

interface DataSource {
    interface RemoteDataSource{
        suspend fun getCountryList():List<Countries>
    }
}