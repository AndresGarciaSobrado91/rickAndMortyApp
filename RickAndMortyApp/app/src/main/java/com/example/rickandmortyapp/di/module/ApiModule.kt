package com.example.rickandmortyapp.di.module

import com.example.rickandmortyapp.data.remote.api.ApiService
import com.example.rickandmortyapp.util.ui.LoadingViewManager
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class ApiModule {

    @Singleton
    @Provides
    fun provideRetrofitService(): ApiService = Retrofit.Builder()
        .baseUrl(ApiService.API_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ApiService::class.java)

}