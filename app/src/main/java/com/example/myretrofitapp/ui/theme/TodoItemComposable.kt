package com.example.myretrofitapp.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.myretrofitapp.model.TodoItem

@Composable
fun TodoItemComposable(
    item: TodoItem,
    onClick: (TodoItem) -> Unit
) {

    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)
        .background(color = MaterialTheme.colorScheme.primaryContainer),
    ) {
        Row(modifier = Modifier.padding(8.dp)) {
            Column(modifier = Modifier.fillMaxWidth().weight(4f)){
                Text(text = "User Id: " + item.userId.toString())

                Text(text = item.title) }
            Column(modifier = Modifier.fillMaxWidth().weight(1f)){
                Checkbox(checked = item.completed, onCheckedChange = {onClick(item)})
            }
        }
    }
}