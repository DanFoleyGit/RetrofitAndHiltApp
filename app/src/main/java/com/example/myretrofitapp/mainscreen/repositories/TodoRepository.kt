package com.example.myretrofitapp.mainscreen.repositories

import com.example.myretrofitapp.model.TodoItem

interface TodoRepository {

    suspend fun getTodos(): List<TodoItem>
}