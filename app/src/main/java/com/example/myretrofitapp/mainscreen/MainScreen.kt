package com.example.myretrofitapp.mainscreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.example.myretrofitapp.Greeting
import com.example.myretrofitapp.model.TodoItem
import com.example.myretrofitapp.ui.theme.TodoItemComposable

@Composable
fun MainScreen(viewModel: MainScreenViewModel, modifier: Modifier) {

    val state = viewModel.mainScreenState.collectAsState()

    Column {

        Greeting(
            name = "Retrofit UI test",
            modifier = modifier
        )


        Button(onClick = { viewModel.refreshList() }) {
            Text(text = "Refresh")
        }

        LazyColumn() {
            items(state.value.todoList) { todo ->
                TodoItemComposable(item = todo, onClick = {viewModel.setItemToComplete(it)} )
            }
        }
    }
}