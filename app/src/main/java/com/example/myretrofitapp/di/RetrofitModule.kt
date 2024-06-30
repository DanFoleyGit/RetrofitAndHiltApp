package com.example.myretrofitapp.di

import com.example.myretrofitapp.retrofit.RetrofitInstance
import com.example.myretrofitapp.retrofit.TodoApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    @Provides
    fun provideTodoApi(): TodoApi {
        return RetrofitInstance.api
    }
}