package com.example.myretrofitapp.model

data class TodoItem(
    val userId: Int,
    val id: Int,
    val title: String,
    var completed: Boolean
)
