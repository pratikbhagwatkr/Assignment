package com.example.assignment.di

import com.example.assignment.common.Constants
import com.example.assignment.data.mapper.CountryResponseMapper
import com.example.assignment.data.remote.ApiInterface
import com.example.assignment.data.repository.GetCountryRepositoryImpl
import com.example.assignment.domain.repository.GetCountryRepository
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class AppModule {


    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit{
        val interceptor = HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY)
        val client = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()
        return Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    @Singleton
    @Provides
    fun provideApiInterface(retrofit: Retrofit) : ApiInterface{
        return retrofit.create(ApiInterface::class.java)
    }

    @Singleton
    @Provides
    fun provideGetCountryRepository(apiInterface: ApiInterface,mapper: CountryResponseMapper): GetCountryRepository{
        return GetCountryRepositoryImpl(apiInterface,mapper)
    }

}