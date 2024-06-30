package com.example.myretrofitapp.mainscreen.usecases

import com.example.myretrofitapp.mainscreen.repositories.TodoRepository
import com.example.myretrofitapp.model.TodoItem
import javax.inject.Inject

class GetTodoItemsUseCase @Inject constructor(
    private val todoRepository: TodoRepository
) {
    suspend fun invoke(): List<TodoItem> {
        return todoRepository.getTodos()
    }
}