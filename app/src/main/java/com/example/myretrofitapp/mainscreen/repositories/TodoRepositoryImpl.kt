package com.example.myretrofitapp.mainscreen.repositories

import android.content.ContentValues.TAG
import android.util.Log
import com.example.myretrofitapp.model.TodoItem
import com.example.myretrofitapp.retrofit.TodoApi
import retrofit2.HttpException
import java.io.IOException

class TodoRepositoryImpl(private val todoApi: TodoApi): TodoRepository {
    override suspend fun getTodos(): List<TodoItem> {
        val response = try {
            todoApi.getTodos()
        } catch (e: IOException) {
            // case where there is no internet
            Log.e("TodoAPI", "getTodos: IOException")
            return emptyList()
        } catch (e: HttpException) {
//            unexpected response
            Log.e(TAG, "TodoAPI: Unexpected response")
            return emptyList()
        }

        if (response.isSuccessful && response.body() != null) {
            return response.body()!!
        } else {
            return emptyList()
        }

    }
}