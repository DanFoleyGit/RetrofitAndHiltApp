package com.example.myretrofitapp.mainscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myretrofitapp.mainscreen.usecases.GetTodoItemsUseCase
import com.example.myretrofitapp.model.TodoItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val getTodoItemsUseCase: GetTodoItemsUseCase,
): ViewModel() {

    /*
    Steps to setup retrofit and Hilt
    1. build .gradle

    add following plugins

        id("kotlin-kapt")
        id("com.google.dagger.hilt.android")

    add the following dependencies

        implementation("com.google.dagger:hilt-android:2.51")
        kapt("com.google.dagger:hilt-android-compiler:2.51")

        implementation("com.squareup.retrofit2:retrofit:2.11.0")
        implementation("com.squareup.retrofit2:converter-gson:2.11.0")
        implementation("com.squareup.okhttp3:logging-interceptor:4.12.0")

    in project build.gradle add
        id("com.google.dagger.hilt.android") version "2.51" apply false

    2 add the the name to the AndroidManifest

        <application
            android:name=".MyRetroFitApplication"

    3. Create the application class for hilt

    5. create the retrofit instance (With interceptor)
        Good practice to store the base URL in a constant

    6. create the API needed for each request

    7. Provide the the retrofit in the retrofit module using hilt.

    8. create viewmodel, views usecase, repository and repository implementation

    9. provide the repository implementation for the repository and handle data in the repository Implementation
     */

    // Home Screen UI state
    private var _mainScreenState = MutableStateFlow(MainScreenUiState())
    var mainScreenState: StateFlow<MainScreenUiState> = _mainScreenState.asStateFlow()

    init {
        getTodoList()
    }

    fun refreshList(){
        _mainScreenState.update { currentState ->
            currentState.copy(todoList = emptyList())
        }
        getTodoList()
    }

    private fun getStaticTodoList() {

        _mainScreenState.update {currentState ->
            currentState.copy(todoList = listOf(
                TodoItem(1,1,"Buy groceries", true),
                TodoItem(1,1,"Buy groceries", false),
                TodoItem(1,1,"Buy groceries", false),
                TodoItem(1,1,"Buy groceries", false)
            )
            )
        }
    }

    private fun getTodoList() {
        viewModelScope.launch {
            _mainScreenState.update { currentState ->
                val list = getTodoItemsUseCase.invoke()
                currentState.copy(
                    todoList = list
                )
            }
        }
    }

    fun setItemToComplete(todoItem: TodoItem) {

        val updatedList = _mainScreenState.value.todoList.map {
            if (it.id == todoItem.id) {
                it.copy(completed = !it.completed)
            } else {
                it
            }
        }

        _mainScreenState.update { currentState ->
            currentState.copy(todoList = updatedList) // Assign the new list to the state
        }
    }
}