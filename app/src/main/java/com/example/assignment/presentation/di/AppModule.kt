package com.example.assignment.presentation.di


import com.example.data.data.mapper.CountryResponseMapper
import com.example.data.data.repository.GetCountryRepositoryImpl
import com.example.data.data.source.DataSource
import com.example.data.data.source.RemoteDataSourceImpl
import com.example.data.data.source.remote.service.ApiService
import com.example.domain.domain.repository.GetCountryRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class AppModule {


    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        val interceptor = HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY)
        val client = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()
        return Retrofit.Builder().baseUrl("https://restcountries.com/v3.1/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    @Singleton
    @Provides
    fun provideApiInterface(retrofit: Retrofit) : ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Singleton
    @Provides
    fun provideDataSource(apiService: ApiService,mapper: CountryResponseMapper): DataSource.RemoteDataSource{
        return RemoteDataSourceImpl(apiService,mapper)
    }

    @Singleton
    @Provides
    fun provideGetCountryRepository(remoteDataSource: DataSource.RemoteDataSource): GetCountryRepository {
        return GetCountryRepositoryImpl(remoteDataSource)
    }

}