package com.example.myretrofitapp.di

import com.example.myretrofitapp.mainscreen.repositories.TodoRepository
import com.example.myretrofitapp.mainscreen.repositories.TodoRepositoryImpl
import com.example.myretrofitapp.retrofit.RetrofitInstance
import com.example.myretrofitapp.retrofit.TodoApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoriesModule {

    @Provides
    fun provideTodoRepository(todoApi: TodoApi): TodoRepository {
        return TodoRepositoryImpl(todoApi)
    }

}