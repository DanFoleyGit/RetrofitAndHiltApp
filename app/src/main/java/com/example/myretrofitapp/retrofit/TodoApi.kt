package com.example.myretrofitapp.retrofit

import com.example.myretrofitapp.model.TodoItem
import retrofit2.Response
import retrofit2.http.GET

interface TodoApi {

    // URL - is https://jsonplaceholder.typicode.com/todos
    @GET("/todos")
    suspend fun getTodos() : Response<List<TodoItem>>
    //    fun getTodos(@Query("API_KEY") key: String) : Response<List<TodoItem>>

}