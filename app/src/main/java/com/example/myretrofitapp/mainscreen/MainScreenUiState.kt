package com.example.myretrofitapp.mainscreen

import com.example.myretrofitapp.model.TodoItem

data class MainScreenUiState(
    var todoList: List<TodoItem> = emptyList()
)
